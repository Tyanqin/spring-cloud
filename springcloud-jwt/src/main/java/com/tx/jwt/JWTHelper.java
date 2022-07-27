package com.tx.jwt;

import com.tx.util.StringHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTHelper {
    @Autowired
    private RsaKeyHelper rsaKeyHelper;

    public JWTHelper() {}

    public String generateToken(IJWTInfo jwtInfo, byte[] priKey, int expire) throws Exception {
        return Jwts.builder().setSubject(jwtInfo.getUniqueName())
                .claim("centerName",jwtInfo.getCenterName())
                .claim("siteId",jwtInfo.getSiteId())
                .claim("userId", jwtInfo.getUserId())
                .claim("userName", jwtInfo.getUserName())
                .claim("type",jwtInfo.getType())
                .claim("expire", Long.valueOf(DateTime.now().plusSeconds(expire).toDate().getTime()))
                .signWith(SignatureAlgorithm.RS256, this.rsaKeyHelper.getPrivateKey(priKey)).compact();
    }

    public String generateToken(IJWTInfo jwtInfo, byte[] priKey, Date expire) throws Exception {
        return Jwts.builder().setSubject(jwtInfo.getUniqueName())
                .claim("centerName",jwtInfo.getCenterName())
                .claim("siteId",jwtInfo.getSiteId())
                .claim("userId", jwtInfo.getUserId())
                .claim("userName", jwtInfo.getUserName())
                .claim("type",jwtInfo.getType())
                .claim("expire", Long.valueOf(expire.getTime()))
                .signWith(SignatureAlgorithm.RS256, this.rsaKeyHelper.getPrivateKey(priKey)).compact();
    }

    public Jws<Claims> parserToken(String token, byte[] pubKey) throws Exception {
        return Jwts.parser().setSigningKey(this.rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
    }

    public IJWTInfo getInfoFromToken(String token, byte[] pubKey) throws Exception {
        Claims body = (Claims)this.parserToken(token, pubKey).getBody();
        Integer type = body.containsKey("type")? Integer.valueOf(body.get("type").toString()):3;

        if(type==2){
            return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get("centerName")),
                    StringHelper.getObjectValue(body.get("siteId")),
                    new DateTime(body.get("expire")).toDate());
        }
        if(type==1){
            return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get("centerName")),
                    new DateTime(body.get("expire")).toDate());
        }
        return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get("centerName")),
                StringHelper.getObjectValue(body.get("siteId")),
                StringHelper.getObjectValue(body.get("userId")),
                StringHelper.getObjectValue(body.get("userName")),
                new DateTime(body.get("expire")).toDate());
    }
}