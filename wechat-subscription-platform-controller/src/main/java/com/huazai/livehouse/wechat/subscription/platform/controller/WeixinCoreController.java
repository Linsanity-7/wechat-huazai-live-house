package com.huazai.livehouse.wechat.subscription.platform.controller;

import com.huazai.livehouse.wechat.subscription.platform.common.util.WeChatSignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @apiNote 微信请求处理核心类
 * @author        :林尚华
 * @date    : 2018/12/29 10:16
 *
 */
@RestController
@RequestMapping(value = "/wechat")
public class WeixinCoreController {

    private static Logger log = LoggerFactory.getLogger(WeixinCoreController.class);

    /**
     * 验证请求是否来自微信服务器
     * @param request 请求的HttpServletRequest对象
     * @return 字符串
     */
    @RequestMapping(value="/access", method= RequestMethod.GET	)
    public String wechatAccess(HttpServletRequest request){
        System.out.println("-------------验证微信服务号信息开始----------");
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        log.info("signature is :"+signature+"timestamp is"+timestamp+"nonce is :"+nonce);
        if (WeChatSignUtil.checkSignature(signature, timestamp, nonce)){
            System.out.println("-----------验证微信服务号结束------------");
            return echostr;
        }else {
            // 此处可以实现其他逻辑
            log.warn("不是微信服务器发过来的请求，请小心！");
            return null;
        }
    }
}
