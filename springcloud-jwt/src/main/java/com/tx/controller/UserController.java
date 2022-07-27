package com.tx.controller;

import com.tx.jwt.JwtUtils;
import com.tx.jwt.RasUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:TanXiao
 * @date:2022/7/26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getUser")
    public String getUser() throws Exception {
        String token = JwtUtils.generateToken("名称：",30, RasUtils.getPrivateKey("D:\\ras\\ras.pri"));
        return "token：   "+token;
    }

}
