package com.tx.common.handler;

import com.tx.common.exception.BaseException;
import com.tx.common.login.UserFreezeException;
import com.tx.common.login.UserNotExistException;
import com.tx.common.login.UserPasswordException;
import com.tx.common.msg.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * 登录异常拦截处理器
 * @author TanXiao
 * @date 2021-05-19 11:15
 */
@RestControllerAdvice(value = "com.tx")
@ResponseBody
public class LoginExceptionHandler extends BaseException {

    private Logger logger = LoggerFactory.getLogger(LoginExceptionHandler.class);

    /**
     * 当前用户不存在
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    public BaseResponse userNotExistException(HttpServletResponse response, BaseException ex){
        logger.error(ex.getMessage());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return new BaseResponse(ex.getStatus(),ex.getMessage());
    }

    /**
     * 用户密码错误
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(UserPasswordException.class)
    public BaseResponse userPasswordException(HttpServletResponse response, BaseException ex){
        logger.error(ex.getMessage());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return new BaseResponse(ex.getStatus(),ex.getMessage());
    }

    /**
     * 当前用户已被冻结
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(UserFreezeException.class)
    public BaseResponse userFreezeException(HttpServletResponse response, BaseException ex){
        logger.error(ex.getMessage());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return new BaseResponse(ex.getStatus(),ex.getMessage());
    }





}
