package com.huazai.livehouse.wechat.subscription.platform.controller;

import com.huazai.livehouse.wechat.subscription.platform.common.util.MessageUtil;
import com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp.TextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatSubscriptionPlatformControllerApplicationTests {

    @Test
    public void contextLoads() {
        TextMessage textMessage = new TextMessage();
        textMessage.setContent("啦啦啦啦啦");
        textMessage.setCreateTime(123456);
        textMessage.setFromUserName("123123");
        textMessage.setToUserName("123124");
        textMessage.setFuncFlag(0);
        textMessage.setMsgType("text");
        System.out.println(MessageUtil.textMessageToXml(textMessage));
    }

}

