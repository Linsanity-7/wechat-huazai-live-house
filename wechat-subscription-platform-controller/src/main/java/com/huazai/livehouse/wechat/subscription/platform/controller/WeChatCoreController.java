package com.huazai.livehouse.wechat.subscription.platform.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.huazai.livehouse.wechat.subscription.platform.common.util.MessageUtil;
import com.huazai.livehouse.wechat.subscription.platform.common.util.WeChatSignUtil;
import com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp.TextMessage;
import com.huazai.livehouse.wechat.subscription.platform.service.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @apiNote 微信请求处理核心类
 * @author        :林尚华
 * @date    : 2018/12/29 10:16
 *
 */
@RestController
@RequestMapping(value = "/wechat")
public class WeChatCoreController {

    private static Logger log = LoggerFactory.getLogger(WeChatCoreController.class);

    @Reference(version = "1.0.0",timeout = 6000,interfaceClass = CoreService.class)
    private CoreService coreService;

    /**
     * 验证请求是否来自微信服务器
     * @param request 请求的HttpServletRequest对象
     * @return 字符串
     */
    @RequestMapping(value="/access", method= RequestMethod.POST	)
    public String wechatAccess(HttpServletRequest request, HttpServletResponse response){
        // xml请求解析
        Object respObj = null;
        try {
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            respObj = coreService.processRequest(requestMap);
        } catch (Exception e) {
            log.error("调用异常",e);
            return null;
        }
        log.debug("转换后的字符串为：{}",MessageUtil.messageToXml(respObj));
        return MessageUtil.messageToXml(respObj);
    }
    /**
     * 验证请求是否来自微信服务器
     * @return 字符串
     */
    @RequestMapping(value="/access", method= RequestMethod.GET)
    public String wechatAccess(@Param("signature") String signature, @Param("timestamp")String timestamp,
                               @Param("nonce")String nonce, @Param("echostr")String echostr){
        log.info("-------------验证微信服务号信息开始----------");
        log.info("signature is :"+signature+"timestamp is"+timestamp+"nonce is :"+nonce);
        if (WeChatSignUtil.checkSignature(signature, timestamp, nonce)){
            log.info("-----------验证微信服务号结束------------");
            return echostr;
        }else {
            // 此处可以实现其他逻辑
            log.warn("不是微信服务器发过来的请求!");
            return null;
        }
    }
}
