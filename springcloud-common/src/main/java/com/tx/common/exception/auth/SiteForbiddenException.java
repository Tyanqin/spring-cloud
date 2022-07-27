package com.tx.common.exception.auth;


import com.tx.common.constant.RestCodeConstants;
import com.tx.common.exception.BaseException;

/**
 * Created by ace on 2017/9/12.
 */
public class SiteForbiddenException extends BaseException {
    public SiteForbiddenException(String message) {
        super(message, RestCodeConstants.EX_SITE_FORBIDDEN_CODE);
    }

}
