package com.tx.jwt;

import java.io.Serializable;
import java.util.Date;

public class JWTInfo implements IJWTInfo, Serializable {
    private String uniqueName;// 唯一名
    private String centerName;
    private String siteId;
    //private String siteName;
    private String userId;
    private String userName;
    private Integer type;//1 表示是center级别的 2表示是site级别的 3表示是user级别的
    private Date expireTime;//过期时间


    public JWTInfo(String uniqueName,String centerName, Date expireTime) {//Integer type,
        this.uniqueName = uniqueName;
        this.centerName = centerName;
        this.type = 1;
        this.expireTime = expireTime;
    }

    public JWTInfo(String uniqueName,String centerName,String siteId,Date expireTime) {//Integer type,
        this.uniqueName = uniqueName;
        this.centerName = centerName;
        this.siteId = siteId;
       // this.siteName = siteName;
        this.type = 2;
        this.expireTime = expireTime;
    }

    public JWTInfo(String uniqueName,String centerName,String siteId,String userId,String userName,Date expireTime) {//Integer type,
        this.uniqueName = uniqueName;
        this.centerName = centerName;
        this.siteId = siteId;
       // this.siteName = siteName;
        this.userId = userId;
        this.userName = userName;
        this.type = 3;
        this.expireTime = expireTime;
    }


    public String getUniqueName() {
        return this.uniqueName;
    }

    @Override
    public String getCenterName() {
        return centerName;
    }

    @Override
    public String getSiteId() {
        return siteId;
    }

    /*@Override
    public String getSiteName() {
        return siteName;
    }*/

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public Integer getType() {
        return type;
    }
    public Date getExpireTime() {
        return this.expireTime;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }
    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    /*public void setSiteName(String siteName) {
        this.siteName = siteName;
    }*/
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setType(Integer type) {
        this.type = type;
    }



    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            JWTInfo jwtInfo = (JWTInfo)o;
            if(this.type.equals(jwtInfo.getType())){
                if(this.type == 3) {
                    if(this.centerName.equals(jwtInfo.centerName)) {
                        return this.userId != null?this.userId.equals(jwtInfo.userId):jwtInfo.userId == null;
                    }
                } else if(this.type == 2) {
                    if(this.centerName.equals(jwtInfo.centerName)) {
                        return this.siteId != null?this.siteId.equals(jwtInfo.siteId):jwtInfo.siteId == null;
                    }
                } else if(this.type == 1) {
                    return this.centerName != null?this.centerName.equals(jwtInfo.centerName):jwtInfo.centerName == null;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public int hashCode() {
        if(this.type == 3) {
            int result = this.centerName != null?this.centerName.hashCode():0;
            return result * 31 + (this.centerName != null?this.centerName.hashCode():0);
        }
        if(this.type == 2) {
            int result = this.centerName != null?this.centerName.hashCode():0;
            return result * 31 + (this.siteId != null?this.siteId.hashCode():0);
        }
        if(this.type == 1) {
            int result = this.centerName != null?this.centerName.hashCode():0;
            return result * 31 + (this.userId != null?this.userId.hashCode():0);
        }
        int result = this.centerName != null?this.centerName.hashCode():0;
        return result * 31 + (this.uniqueName != null?this.uniqueName.hashCode():0);
    }
}