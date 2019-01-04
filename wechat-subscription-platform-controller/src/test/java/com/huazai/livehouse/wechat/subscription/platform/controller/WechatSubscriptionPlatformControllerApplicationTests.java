package com.huazai.livehouse.wechat.subscription.platform.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.huazai.livehouse.wechat.subscription.platform.common.util.MessageUtil;
import com.huazai.livehouse.wechat.subscription.platform.pojo.https.req.AccessTokenRequest;
import com.huazai.livehouse.wechat.subscription.platform.pojo.https.req.Button;
import com.huazai.livehouse.wechat.subscription.platform.pojo.https.req.ButtonRequest;
import com.huazai.livehouse.wechat.subscription.platform.pojo.https.req.SubButton;
import com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp.TextMessage;
import com.huazai.livehouse.wechat.subscription.platform.service.SendHttpsReqService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void test2(){
        Button button1 = new Button();
        button1.setType("click");
        button1.setName("今日歌曲");
        button1.setKey("V1001_TODAY_MUSIC");
        Button button2 = new Button();
        button2.setName("菜单");
        List<SubButton> subButtons = new ArrayList<>();
        SubButton subButton1 = new SubButton();
        subButton1.setType("view");
        subButton1.setName("搜索");
        subButton1.setUrl("http://www.soso.com");
        SubButton subButton2 = new SubButton();
        subButton2.setType("click");
        subButton2.setName("赞一个");
        subButton2.setKey("V1001_GOOD");
        subButtons.add(subButton1);
        subButtons.add(subButton2);
        button2.setSub_button(subButtons);
        ButtonRequest buttonRequest = new ButtonRequest();
        List<Button> buttons = new ArrayList<>();
        buttons.add(button1);
        buttons.add(button2);
        buttonRequest.setButton(buttons);
        sendHttpsReqService.doPost(buttonRequest);
    }

}

