package com.tx.jwt;

import java.util.Date;

public abstract interface IJWTInfo
{
    public abstract String getUniqueName();
    public abstract String getCenterName();
    public abstract String getSiteId();
    //public abstract String getSiteName();
    public abstract String getUserId();
    public abstract String getUserName();

    public abstract Date getExpireTime();

    /**
     *
     * @return 1 表示是center级别的 2表示是site级别的 3是user级别的
     */
    public abstract Integer getType();

}
