package com.tx.api.vo.user;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author:TanXiao
 * @date:2022/7/26
 */
@Accessors(chain = true)
@Data
public class UserInfo implements Serializable {

    public String id;
    public String uniqueName;
    public String username;
    public String password;
    private String description;
}
