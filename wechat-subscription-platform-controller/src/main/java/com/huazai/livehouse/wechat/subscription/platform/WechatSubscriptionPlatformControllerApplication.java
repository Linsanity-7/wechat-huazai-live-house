package com.huazai.livehouse.wechat.subscription.platform;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfig
@SpringBootApplication
public class WechatSubscriptionPlatformControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatSubscriptionPlatformControllerApplication.class, args);
    }

}

