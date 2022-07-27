package com.tx.common.exception.auth;


import com.tx.common.constant.RestCodeConstants;
import com.tx.common.exception.BaseException;

/**
 * Created by ace on 2017/9/8.
 */
public class NonLoginException extends BaseException {
    public NonLoginException(String message) {
        super(message, RestCodeConstants.EX_USER_INVALID_CODE);
    }
}
