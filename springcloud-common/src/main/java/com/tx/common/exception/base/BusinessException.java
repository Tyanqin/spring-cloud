package com.tx.common.exception.base;

import com.tx.common.constant.RestCodeConstants;
import com.tx.common.exception.BaseException;

/**
 * 业务异常基础类
 * @author TanXiao
 * @date 2022-05-19 11:09
 */
public class BusinessException extends BaseException {

    public BusinessException(String message){
        super(message, RestCodeConstants.EX_USER_DOSE_NOT_EXIST);
    }



}
