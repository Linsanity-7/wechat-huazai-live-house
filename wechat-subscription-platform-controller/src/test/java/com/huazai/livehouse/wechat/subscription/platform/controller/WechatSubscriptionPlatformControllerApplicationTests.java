package com.huazai.livehouse.wechat.subscription.platform.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.huazai.livehouse.wechat.subscription.platform.common.util.MessageUtil;
import com.huazai.livehouse.wechat.subscription.platform.pojo.https.req.AccessTokenRequest;
import com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp.TextMessage;
import com.huazai.livehouse.wechat.subscription.platform.service.SendHttpsReqService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatSubscriptionPlatformControllerApplicationTests {

    @Value("${appId}")
    private String appId;

    @Value("${appSecret}")
    private String appSecret;

    @Value("${wechat.url.get.access_token}")
    private String accessTokenUrl;

    @Reference(version = "1.0.0",interfaceClass = SendHttpsReqService.class,timeout = 60000)
    private SendHttpsReqService sendHttpsReqService;

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
        System.out.println("appId="+appId);
        System.out.println("appSecret="+appSecret);
    }

    @Test
    public void test1(){
        System.out.println("url = " + accessTokenUrl + "\n" + "appid=" + appId + "\n" + "secret=" + appSecret +"\n" );
        AccessTokenRequest request = new AccessTokenRequest();
        request.setUrl(accessTokenUrl);
        request.setAppId(appId);
        request.setSecret(appSecret);

        sendHttpsReqService.doGet(request);
    }

}

