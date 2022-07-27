package com.tx.data.service;

import com.tx.common.msg.ObjectRestResponse;
import com.tx.entity.StudentInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:TanXiao
 * @date:2022/6/9
 */
@Component
public class  StudentInfoClientFeignFallBack implements StudentInfoFeign {

    @Override
    public ObjectRestResponse<List<StudentInfo>> all() {
        throw new RuntimeException("all() 方法出现异常");
    }

    @Override
    public ObjectRestResponse<StudentInfo> getId(String id) {
        return null;
    }
}
