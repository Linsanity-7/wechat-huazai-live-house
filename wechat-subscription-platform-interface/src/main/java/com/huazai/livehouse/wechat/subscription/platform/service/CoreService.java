package com.huazai.livehouse.wechat.subscription.platform.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @apiNote :核心服务类
 * @author        :林尚华
 * @date    : 2018/12/29 15:39
 */
public interface CoreService {
    /**
     * 处理微信发来的请求（包括事件的推送）
     * @param requestMap
     * @return
     */
    Object processRequest(Map<String,String> requestMap);
}
