package com.huazai.livehouse.wechat.subscription.platform;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.huazai.livehouse.wechat.subscription.platform.pojo.https.req.AccessTokenRequest;
import com.huazai.livehouse.wechat.subscription.platform.service.SendHttpsReqService;
import com.huazai.livehouse.wechat.subscription.platform.thread.UpdateAccessTokenThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * Springboot 启动后执行
 * @author 林尚华
 * @date 2019/01/02 22:48
 */
@Service
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger log = LoggerFactory.getLogger(ApplicationStartup.class);

    @Resource
    private UpdateAccessTokenThread updateAccessTokenThread;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext context = contextRefreshedEvent.getApplicationContext();
        //创建线程池，将更新AccessToken的方法放入线程池中执行
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("updateAccessToken-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(
                1,1,0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
        singleThreadPool.execute(updateAccessTokenThread);
    }
}
