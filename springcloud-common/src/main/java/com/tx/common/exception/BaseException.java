package com.tx.common.exception;

/**
 * 基础异常类
 * @author TanXiao
 * @date 2022-05-19 09:40
 */
public class BaseException extends RuntimeException {

    private int status = 500;

    public int getStatus(){ return this.status; }

    public void setStatus(int status){this.status = status;}

    public BaseException(){}

    public BaseException(String message,int status){ super(message);this.status = status; }

    public BaseException(String message){
        super(message);
    }

    public BaseException(String message,Throwable cause){
        super(message,cause);
    }

    public BaseException(Throwable cause){super(cause);}

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) { super(message, cause, enableSuppression, writableStackTrace); }

}
