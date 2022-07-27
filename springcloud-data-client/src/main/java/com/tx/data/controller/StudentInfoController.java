package com.tx.data.controller;

import com.tx.common.msg.ObjectRestResponse;
import com.tx.entity.StudentInfo;
import com.tx.data.service.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:TanXiao
 * @date:2022/7/19
 */

@RestController
@Api(value = "学生信息操作接口",tags = {"学生信息API"})
public class StudentInfoController {

    @Autowired
    private StudentInfoFeign studentInfoFeign;

    @GetMapping("/studentInfo/all")
    public ObjectRestResponse<List<StudentInfo>> all(){
          return studentInfoFeign.all();
    }

    @GetMapping(value="/studentInfo/{id}")
    public  ObjectRestResponse<StudentInfo>  get(@PathVariable("id")  String id){
        return studentInfoFeign.getId(id);
    }
}
