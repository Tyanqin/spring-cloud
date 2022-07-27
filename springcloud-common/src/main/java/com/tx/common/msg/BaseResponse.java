package com.tx.common.msg;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author TanXiao
 * @date 2022-05-19 10:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class BaseResponse {

    @ApiModelProperty(value = "状态")
    private int status = 200;

    @ApiModelProperty(value = "消息")
    private String message;

    public BaseResponse(String message) {
        this.message = message;
    }
}
