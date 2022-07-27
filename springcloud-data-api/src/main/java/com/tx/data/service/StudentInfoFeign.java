package com.tx.data.service;

import com.tx.common.msg.ObjectRestResponse;
import com.tx.entity.StudentInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author:TanXiao
 * @date:2022/7/20
 */
@FeignClient(value = "spring-cloud-data-v1",fallbackFactory = StudentInfoFeignFallBackFactory.class)
public interface StudentInfoFeign {

    @GetMapping(value = "/studentInfo/all")
    public ObjectRestResponse<List<StudentInfo>> all();

    @GetMapping(value="/studentInfo/{id}")
    public  ObjectRestResponse<StudentInfo>  getId(String id);
}
