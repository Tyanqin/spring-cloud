package com.tx.data.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:TanXiao
 * @date:2022/7/22
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${age}")
    private String age;

    @Value("${name}")
    private String name;

    @Value("${sex}")
    private String sex;

    @RequestMapping("/cloudAll")
    public String getAll(){
        return this.age+"   ====   "+this.name+"   ====    "+this.sex;
    }

    @RequestMapping("/cloud/age")
    public String getAge () {
        return this.age;
    }

    @RequestMapping("/cloud/sex")
    public String getSex () {
        return this.sex;
    }

    @RequestMapping("/cloud/name")
    public String getName() {
        return this.name;
    }

}