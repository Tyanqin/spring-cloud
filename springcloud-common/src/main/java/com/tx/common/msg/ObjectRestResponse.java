package com.tx.common.msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author TanXiao
 * @date 2022-05-19 10:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class ObjectRestResponse<T> extends BaseResponse {

    private T data;

    public ObjectRestResponse data(T data){
        this.setData(data);
        return this;
    }
    public ObjectRestResponse message(String message){
        this.setMessage(message);
        return this;
    }
}
