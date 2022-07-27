package com.tx.common.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author TanXiao
 * @date 2022-05-26 15:51
 */

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "用户实例")
public class SessionUser  implements Serializable {

    @Id
    @ApiModelProperty(value = "用户ID")
    private Integer id;

    @Column(name = "userName")
    @ApiModelProperty(value = "用户名称")
    private String userName;

    @Column(name = "password")
    @ApiModelProperty(value = "用户密码")
    private String password;

    @Column(name = "loginName")
    @ApiModelProperty(value = "登录名称")
    private String loginName;

    @Column(name = "iphone")
    @ApiModelProperty(value = "用户手机")
    private String iphone;

    @Column(name = "permissionId")
    @ApiModelProperty(value = "权限ID")
    private String permissionId;

    @Column(name = "departmentId")
    @ApiModelProperty(value = "部门ID")
    private Integer departmentId;

    @Column(name = "isFreeze")
    @ApiModelProperty(value = "是否冻结？0、冻结 1、正常")
    private String isFreeze;

    @Column(name = "isDelete")
    @ApiModelProperty(value = "是否删除？0、删除 1、正常")
    private String isDelete;

}
