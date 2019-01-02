package com.huazai.livehouse.wechat.subscription.platform.timingtask;

import com.huazai.livehouse.wechat.subscription.platform.common.util.DateUtils;
import com.huazai.livehouse.wechat.subscription.platform.pojo.https.req.AccessTokenRequest;
import com.huazai.livehouse.wechat.subscription.platform.service.SendHttpsReqService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 上海美市科技有限公司开发部
 * @author         :linshanghua
 * @date     : 2018/12/27 17:05
 * 定时任务类
 */
@Service
public class ScheduledService {

    private static Logger log = LoggerFactory.getLogger(ScheduledService.class);

    @Resource
    private SendHttpsReqService sendHttpsReqService;

    @Value("${appId}")
    private String appId;

    @Value("${appSecret}")
    private String appSecret;

    @Value("${wechat.url.get.access_token}")
    private String accessTokenUrl;

    /**
     * 定时更新画像内容
     * 定时任务，每天0点执行
     */
    @Scheduled(cron = "${scheduled.timing.get.access_token}")
    public void updatingThePortraits(){
        log.info("定时任务-------获取access_token执行，当前时间：{}", DateUtils.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
        log.info("url = {}，appid = {}，secret = {}",accessTokenUrl,appId,appSecret);
        AccessTokenRequest request = new AccessTokenRequest();
        request.setUrl(accessTokenUrl);
        request.setAppId(appId);
        request.setSecret(appSecret);
        sendHttpsReqService.doGet(request);
        log.info("定时任务结束！当前时间：{}", DateUtils.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }
}
