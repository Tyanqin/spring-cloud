package com.tx.common.login;

import com.tx.common.constant.RestCodeConstants;
import com.tx.common.exception.BaseException;

/**
 * @author:TanXiao
 * @date:2022/7/20
 */
public class UserPasswordException extends BaseException {
    public UserPasswordException(String message) {
        super(message, RestCodeConstants.EX_USER_INVALID_CODE);
    }

}
