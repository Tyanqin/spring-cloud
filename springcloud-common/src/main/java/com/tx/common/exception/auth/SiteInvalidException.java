package com.tx.common.exception.auth;


import com.tx.common.constant.RestCodeConstants;
import com.tx.common.exception.BaseException;

/**
 * Created by ace on 2017/9/10.
 */
public class SiteInvalidException extends BaseException {
    public SiteInvalidException(String message) {
        super(message, RestCodeConstants.EX_SITE_INVALID_CODE);
    }
}
