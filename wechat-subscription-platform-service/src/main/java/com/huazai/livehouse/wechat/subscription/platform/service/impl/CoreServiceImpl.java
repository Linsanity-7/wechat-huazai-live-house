package com.huazai.livehouse.wechat.subscription.platform.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huazai.livehouse.wechat.subscription.platform.common.util.MessageUtil;
import com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp.Article;
import com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp.NewsMessage;
import com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp.TextMessage;
import com.huazai.livehouse.wechat.subscription.platform.service.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 上海美市科技有限公司开发部
 *
 * @author        :林尚华
 * @date    : 2018/12/29 15:43
 * @Description:
 */
@Service(version = "1.0.0",interfaceClass = CoreService.class,timeout = 6000)
public class CoreServiceImpl implements CoreService {

    private static Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);

    @Value("$qqface.regex")
    private String qqfaceRegex;

    @Override
    public Object processRequest(Map<String,String> requestMap) {
        Object object = null;
        // 发送方帐号（open_id）
        String fromUserName = requestMap.get("FromUserName");
        // 公众帐号
        String toUserName = requestMap.get("ToUserName");
        // 消息类型
        String msgType = requestMap.get("MsgType");
        log.info("获取到的参数：FromUserName={}，ToUserName={}，MsgType={}。",fromUserName,toUserName,msgType);
        // 回复文本消息
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setFuncFlag(0);

        // 创建图文消息
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        newsMessage.setFuncFlag(0);

        List<Article> articleList = new ArrayList<>();
        // 接收文本消息内容
        String content = requestMap.get("Content");
        // 自动回复文本消息
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            //如果用户发送表情，则回复同样表情。
            if (isQqFace(content)) {
                textMessage.setContent(content);
                object = textMessage;
            } else {
                switch (content){
                    default: {
                        StringBuffer buffer = new StringBuffer();
                        buffer.append("您好，我是小8，请回复数字选择服务：").append("\n\n");
                        buffer.append("11 可查看测试单图文").append("\n");
                        buffer.append("12  可测试多图文发送").append("\n");
                        buffer.append("13  可测试网址").append("\n");

                        buffer.append("或者您可以尝试发送表情").append("\n\n");
                        buffer.append("回复“1”显示此帮助菜单").append("\n");
                        String respContent = String.valueOf(buffer);
                        textMessage.setContent(respContent);
                        object = textMessage;
                        break;
                    }
                }
            }
        }
        return object;
    }

    /**
     * 判断是否是qq表情
     * @param content 内容
     * @return
     */
    private boolean isQqFace(String content){
        boolean result = false;
        Pattern pattern = Pattern.compile(qqfaceRegex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.matches()){
            result = true;
        }
        return result;
    }
}
