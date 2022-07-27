package com.tx.jwt;

/**
 * @author:TanXiao
 * @date:2022/7/26
 */
public class TestRas {

    private static final String pubKeyPath = "D:\\ras\\ras.pub";
    private static final String priKeyPath = "D:\\ras\\ras.pri";

    public static void main(String args[]) throws Exception {
        //生产公钥和私钥
        RasUtils.generateKey(pubKeyPath,priKeyPath,"234");
    }

}

