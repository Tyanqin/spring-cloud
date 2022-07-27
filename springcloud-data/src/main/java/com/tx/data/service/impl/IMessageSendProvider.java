package com.tx.data.service.impl;

import com.tx.data.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author:TanXiao
 * @date:2022/7/26
 */

@EnableBinding(Source.class)  //定义消息的推送管道
public class IMessageSendProvider implements MessageProvider {

    @Resource
    private MessageChannel output;  //消息发送管道
    @Override
    public String send() {
        String  id = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(id).build());
        System.out.println("**************id**********"+id);
        return "success";
    }
}
