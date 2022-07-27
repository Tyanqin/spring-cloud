package com.tx.common.util;

/**
 * @author TanXiao
 * @date 2022-05-20 14:27
 */
public class Str {

    public static StringBuffer getStr(StringBuffer sqlBuffer, String str) {
       return sqlBuffer.delete(sqlBuffer.lastIndexOf(str), sqlBuffer.length());
    }
}
