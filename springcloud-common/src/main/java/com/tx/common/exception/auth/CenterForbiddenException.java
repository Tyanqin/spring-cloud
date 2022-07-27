package com.tx.common.exception.auth;


import com.tx.common.constant.RestCodeConstants;
import com.tx.common.exception.BaseException;


/**
 * Created by ace on 2017/9/12.
 */
public class CenterForbiddenException extends BaseException {
    public CenterForbiddenException(String message) {
        super(message, RestCodeConstants.EX_CENTER_FORBIDDEN_CODE);
    }

}
