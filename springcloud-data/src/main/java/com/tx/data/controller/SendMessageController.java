package com.tx.data.controller;

import com.tx.data.service.impl.IMessageSendProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:TanXiao
 * @date:2022/7/26
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageSendProvider iMessageSendProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return iMessageSendProvider.send();
    }
}

