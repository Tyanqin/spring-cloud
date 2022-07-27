package com.tx.common.exception.auth;


import com.tx.common.constant.RestCodeConstants;
import com.tx.common.exception.BaseException;

/**
 * Created by ace on 2017/9/10.
 */
public class CenterTokenException extends BaseException {
    public CenterTokenException(String message) {
        super(message, RestCodeConstants.EX_CENTER_INVALID_CODE);
    }
}
