package com.huazai.livehouse.wechatsubscriptionplatformservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeChatSubscriptionPlatformServiceApplicationTests {

    @Value("appId")
    private String appId;

    @Value("appSecret")
    private String appSecret;

    @Test
    public void contextLoads() {
        System.out.println("appId="+appId);
        System.out.println("appSecret="+appSecret);

    }

}

