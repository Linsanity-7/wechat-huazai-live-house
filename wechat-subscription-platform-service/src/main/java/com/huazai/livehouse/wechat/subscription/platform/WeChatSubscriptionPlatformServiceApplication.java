package com.huazai.livehouse.wechat.subscription.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class WeChatSubscriptionPlatformServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeChatSubscriptionPlatformServiceApplication.class, args);
    }

}

