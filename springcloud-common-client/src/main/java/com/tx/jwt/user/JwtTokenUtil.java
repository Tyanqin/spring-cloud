package com.tx.jwt.user;

import com.tx.configuration.KeyConfiguration;
import com.tx.jwt.IJWTInfo;
import com.tx.jwt.JWTHelper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 * @author ace
 * @version 2017/9/10
 */
@Component
public class JwtTokenUtil {

    @Value("${jwt.expire}")
    private int expire;

    @Value("${center.expire}")
    private int center_expire;

    @Value("${center.site.expire}")
    private int site_expire;

    @Autowired
    private KeyConfiguration keyConfiguration;
    @Autowired
    private JWTHelper jwtHelper;

    public String generateToken(Integer type,IJWTInfo jwtInfo) throws Exception {
        Date expireTime = null;
        if(type == 1) {
            expireTime = DateTime.now().plusSeconds(center_expire).toDate();
            return jwtHelper.generateToken(jwtInfo, keyConfiguration.getCenterPriKey(), expireTime);
        }else if(type == 2){
            expireTime = DateTime.now().plusSeconds(site_expire).toDate();
            return jwtHelper.generateToken(jwtInfo, keyConfiguration.getSitePriKey(), expireTime);
        }else {
            expireTime = DateTime.now().plusSeconds(expire).toDate();
            return jwtHelper.generateToken(jwtInfo, keyConfiguration.getUserPriKey(), expireTime);
        }
    }

    public IJWTInfo getInfoFromToken(Integer type, String token) throws Exception {
        if(type == 1) {
            IJWTInfo infoFromToken = jwtHelper.getInfoFromToken(token, keyConfiguration.getCenterPubKey());
            return infoFromToken;
        }else if(type == 2){
            IJWTInfo infoFromToken = jwtHelper.getInfoFromToken(token, keyConfiguration.getSitePubKey());
            return infoFromToken;
        }else {
            IJWTInfo infoFromToken = jwtHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
            return infoFromToken;
        }
    }

}
