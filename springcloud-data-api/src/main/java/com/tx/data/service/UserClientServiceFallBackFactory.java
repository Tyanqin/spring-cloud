package com.tx.data.service;

import com.tx.common.msg.ObjectRestResponse;
import com.tx.entity.StudentInfo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:TanXiao
 * @date:2022/6/8
 */
@Component
class StudentInfoFeignFallBackFactory implements FallbackFactory<StudentInfoFeign> {
    @Override
    public StudentInfoFeign create(Throwable throwable) {
        return new StudentInfoFeign() {
            @Override
            public ObjectRestResponse<List<StudentInfo>> all() {
                 return new ObjectRestResponse<>();
            }

            @Override
            public ObjectRestResponse<StudentInfo> getId(String id) {
                return null;
            }
        };
    }
}
