package com.huazai.livehouse.wechat.subscription.platform.thread;

import com.huazai.livehouse.wechat.subscription.platform.common.util.DateUtils;
import com.huazai.livehouse.wechat.subscription.platform.pojo.https.req.AccessTokenRequest;
import com.huazai.livehouse.wechat.subscription.platform.service.SendHttpsReqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @apiNote :更新access_token线程类
 * @author        :林尚华
 * @date    : 2019/01/03 09:06
 */
@Component
public class UpdateAccessTokenThread implements Runnable{

    private static Logger log = LoggerFactory.getLogger(UpdateAccessTokenThread.class);

    @Resource
    private SendHttpsReqService sendHttpsReqService;

    @Value("${appId}")
    private String appId;

    @Value("${appSecret}")
    private String appSecret;

    @Value("${wechat.url.get.access_token}")
    private String accessTokenUrl;

    @Value("${wechat.url.get.access_token.update.time}")
    private long updateTime;

    @Override
    public void run() {
        log.info("执行线程{}获取access_token，参数appId={}，appSecret={},url={}",Thread.currentThread().getName(),appId,appSecret,accessTokenUrl);
        AccessTokenRequest request = new AccessTokenRequest(accessTokenUrl,appId,appSecret);
        while (true){
            log.info("线程{}执行更新Access_token操作！更新时间：{}", DateUtils.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
            sendHttpsReqService.doGet(request);
            try {
                Thread.sleep(updateTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
