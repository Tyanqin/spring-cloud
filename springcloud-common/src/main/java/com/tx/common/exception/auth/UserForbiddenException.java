package com.tx.common.exception.auth;


import com.tx.common.constant.RestCodeConstants;
import com.tx.common.exception.BaseException;

/**
 *
 * @author ace
 * @version 2017/9/12
 */
public class UserForbiddenException extends BaseException {
    public UserForbiddenException(String message) {
        super(message, RestCodeConstants.EX_USER_FORBIDDEN_CODE);
    }
}
