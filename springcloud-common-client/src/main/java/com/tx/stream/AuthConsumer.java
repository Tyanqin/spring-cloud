package com.tx.stream;

import com.tx.jwt.IJWTInfo;
import com.tx.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by malong on 2018/3/11.
 */
public abstract class AuthConsumer {

    @Autowired
    JWTHelper jwtHelper;

    public IJWTInfo getInfoFromToken(String authname, String token) throws Exception{
        return null;//jwtHelper.getInfoFromToken(message.getHeaders().get("tokenName").toString(),message.getHeaders().get("tokenValue").toString());
    }

    public void checkAuth(String authname,String token,String handleName){
        //message.getHeaders().get("tokenName").toString(),message.getHeaders().get("tokenValue").toString()
    }
}
