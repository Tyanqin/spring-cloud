package com.tx.data.controller;

import com.tx.common.biz.BaseController;
import com.tx.common.login.UserNotExistException;
import com.tx.entity.StudentInfo;
import com.tx.data.service.StudentInfoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:TanXiao
 * @date:2022/7/18
 */
@RestController
@RequestMapping("/studentInfo")
@Api(value = "学生信息操作接口",tags = {"学生信息API"})
public class StudentInfoController extends BaseController<StudentInfoService, StudentInfo> {

//    @Autowired
//    private StudentInfoService studentInfoService;
//
//    //此处用切面进行封装
////    @Autowired
////    private HttpServletResponse response;
//
//    @ApiOperation(value = "根据ID查询对象", notes = "请查看数据字典")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="id",value="学生信息ID",required=true,paramType="path",defaultValue = "1")
//    })
//    @ApiResponses({
//            @ApiResponse(code = 400,message = "参数类型错误"),
//            @ApiResponse(code = 401,message = "请求参数无效"),
//            @ApiResponse(code = 403,message = "失败的请求"),
//            @ApiResponse(code = 404,message = "接口未找到"),
//    })
    @GetMapping("/findByIdss/{id}")
    public List<StudentInfo> findByIdss(@PathVariable("id") String id){
            throw new UserNotExistException("自定义异常！");
//        return new ArrayList<>();
    }
//
//    @PostMapping("/insertStudentInfo")
//    public void insertStudentInfo(@RequestBody StudentInfo studentInfo){
//         studentInfoService.insertStudent(studentInfo);
//    }

}
