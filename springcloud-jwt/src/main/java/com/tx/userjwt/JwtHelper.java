package com.tx.userjwt;

import com.tx.api.vo.user.UserInfo;
import com.tx.jwt.RsaKeyHelper;
import io.jsonwebtoken.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.joda.time.DateTime;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.UUID;

/**
 * @author:TanXiao
 * @date:2022/7/27
 */
public class JwtHelper {

    //@Autowired
    private RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

        public JwtHelper(){}

    public String generateToken(UserInfo userInfo, String str, int expire) throws Exception {
        return Jwts.builder().setSubject(userInfo.getUniqueName())
                .claim("id",userInfo.getId())
                .claim("userName",userInfo.getUsername())
                .claim("description", userInfo.getDescription())
                .claim("expire", Long.valueOf(DateTime.now().plusSeconds(expire).toDate().getTime()))
                .signWith(SignatureAlgorithm.HS256, "admin").compact();
    }

    public String generateToken(UserInfo userInfo, String token, Date expire) throws Exception {
        return Jwts.builder().setSubject(userInfo.getUniqueName())
                .claim("id",userInfo.getId())
                .claim("userName",userInfo.getUsername())
                .claim("description", userInfo.getDescription())
                .claim("expire", Long.valueOf(expire.getTime()))
                .signWith(SignatureAlgorithm.RS256, token).compact();
    }

    //加密生成token
    public String generateToken(){
        JwtBuilder jwtBuilder = Jwts.builder();
        String token = jwtBuilder.setHeaderParam("typ","Jwt")
                .setHeaderParam("alg","HS256")
                .claim("userName","tom")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.RS256,"123456").compact();
            return token;
    }

    //解密
    public void parseToken(String token){
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey("123456").parseClaimsJws(token);
            Claims body = claimsJws.getBody();
             body.get("userName");
    }



    public Jws<Claims> parserToken(String token) throws Exception {
        return Jwts.parser().setSigningKey("admin").parseClaimsJws(token);
    }

    /**
     * RSA：随机生成密钥对
     *
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-2048位
        keyPairGen.initialize(2048, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   	// 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  		// 得到公钥

        // 得到公钥字符串
        String publicKeyStr = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyStr = new String(Base64.encodeBase64((privateKey.getEncoded())));

        System.out.println("随机生成的公钥为:" + publicKeyStr);
        System.out.println("随机生成的私钥为:" + privateKeyStr);
    }


    public static void main(String args[]) throws Exception {
        JwtHelper jwtHelper = new JwtHelper();
        UserInfo userInfo = new UserInfo();
        userInfo.setId("0001").setUsername("zhangsan").setPassword("123456").setUniqueName("tom");
        System.out.println(jwtHelper.generateToken(userInfo, " ", 1));
        String str = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b20iLCJpZCI6IjAwMDEiLCJ1c2VyTmFtZSI6InpoYW5nc2FuIiwiZXhwaXJlIjoxNjU4ODk2NTQ0OTQxfQ.NSGzcOxn2XhWJAggIPVOkiVDJZEkiEUNBczFQkwrzmM";
        System.out.println(jwtHelper.parserToken(str).toString());
    }

}
