package com.tx.common.biz;

import com.tx.common.msg.ObjectRestResponse;
import com.tx.common.msg.TableResultResponse;
import com.tx.common.util.Query;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author TanXiao
 * @date 2022-05-26 11:25
 */

public class BaseController  <Biz extends BaseBiz,Entity> {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected Biz baseBiz;

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "通用:写入新对象", notes = "请查看数据字典")
    public ObjectRestResponse<Entity> add(@RequestBody Entity entity){
        baseBiz.insertSelective(entity);
        return new ObjectRestResponse<Entity>().data(entity);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "通用:根据ID得到对象", notes = "请查看数据字典")
//    @ApiImplicitParams(
//            { @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorize", value = "信息参数", required = false) })
    public ObjectRestResponse<Entity> get(@PathVariable String id){
        ObjectRestResponse<Entity> entityObjectRestResponse = new ObjectRestResponse<>();
        Object o = baseBiz.selectById(id);
        entityObjectRestResponse.data((Entity)o);
        return entityObjectRestResponse;
    }

    @PostMapping("/upd")
    @ResponseBody
    @ApiOperation(value = "通用:通过ID更新对象-单表", notes = "请查看数据字典")
    public ObjectRestResponse<Entity> update(@RequestBody Entity entity){
        baseBiz.updateSelectiveById(entity);
        return new ObjectRestResponse<Entity>().data(entity);
    }

    @PostMapping("/selectOne")
    @ResponseBody
    @ApiOperation(value = "通用:通过字段获取对象", notes = "请查看数据字典")
    public ObjectRestResponse<Entity> selectOne(@RequestBody Entity entity){
        Object o = baseBiz.selectOne(entity);
        return new ObjectRestResponse<Entity>().data((Entity) o);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "通用:通过ID删除对象", notes = "请查看数据字典")
    public ObjectRestResponse<Entity> remove(@PathVariable String id){
        baseBiz.deleteById(id);
        return new ObjectRestResponse<Entity>();
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "通用:获取所有对象", notes = "请查看数据字典")
//    @HystrixCommand(commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    },fallbackMethod = "allFallback")
    public ObjectRestResponse<List<Entity>> all(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List<Entity> eList = baseBiz.selectListAll();
        return new ObjectRestResponse<List<Entity>>().data(eList).message("200");
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "通用:根据传入条件分页", notes = "请查看数据字典，page,limit是特殊值")
    public TableResultResponse<Entity> list(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit){
        //查询列表数据
        Query query = new Query(page,limit);
        return baseBiz.selectPage(query);
    }

    public   ObjectRestResponse<List<Entity>> allFallback(){
        return new ObjectRestResponse<>().data("").message("对不起我的错!");
    }

}
