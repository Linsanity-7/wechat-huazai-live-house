package com.huazai.livehouse.wechat.subscription.platform;

import com.huazai.livehouse.wechat.subscription.platform.pojo.https.req.AccessTokenRequest;
import com.huazai.livehouse.wechat.subscription.platform.service.SendHttpsReqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * Springboot 启动后执行
 * @author 林尚华
 * @date 2019/01/02 22:48
 */
@Service
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger log = LoggerFactory.getLogger(ApplicationStartup.class);

    @Value("${appId}")
    private String appId;

    @Value("${appSecret}")
    private String appSecret;

    @Value("${wechat.url.get.access_token}")
    private String accessTokenUrl;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext context = contextRefreshedEvent.getApplicationContext();
        log.info("Springboot启动完毕！执行获取access_token，参数appId={}，appSecret={},url={}",appId,appSecret,accessTokenUrl);
        SendHttpsReqService sendHttpsReqService = context.getBean(SendHttpsReqService.class);
        AccessTokenRequest request = new AccessTokenRequest(accessTokenUrl,appId,appSecret);
        sendHttpsReqService.doGet(request);
    }
}
