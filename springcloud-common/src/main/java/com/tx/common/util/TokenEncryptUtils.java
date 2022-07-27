package com.tx.common.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author TanXiao
 * @date 2022-05-27 13:20
 */

@Component
public class TokenEncryptUtils {

    //生成token
    public  static   String genToken(){
        return UUID.randomUUID().toString().replace("-", "");
    }





    public static void main(String args[]){
        for (int i = 0; i < 10; i++) {
            System.out.println(TokenEncryptUtils.genToken());
        }
    }


//    public static String getToken(User user) {
//        String token="";
//        token= JWT.create().withAudience(String.valueOf(user.getId()))
//                .sign(Algorithm.HMAC256(user.getPassword()));
//        return token;
//    }



}
