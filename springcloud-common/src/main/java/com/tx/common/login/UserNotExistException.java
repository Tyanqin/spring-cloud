package com.tx.common.login;

import com.tx.common.constant.RestCodeConstants;
import com.tx.common.exception.BaseException;

/**
 * @author:TanXiao
 * @date:2022/7/20
 */
public class UserNotExistException extends BaseException {
    public UserNotExistException(String message) {
        super(message, RestCodeConstants.EX_USER_INVALID_CODE);
    }
}
