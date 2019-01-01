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

        List<Article> articleList = new ArrayList<>();
        switch (msgType){
            case MessageUtil.REQ_MESSAGE_TYPE_TEXT: object = automaticTextReply(fromUserName,toUserName,requestMap);break;
            case MessageUtil.REQ_MESSAGE_TYPE_EVENT: object = monitorEventTrigger(fromUserName,toUserName,requestMap);break;
            default:;
        }
        return object;
    }

    /**
     * 判断是否是qq表情
     * @param content 内容
     * @return
     */
    private boolean isQqFace(String content){
        String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
        boolean result = false;
        Pattern pattern = Pattern.compile(qqfaceRegex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.matches()){
            result = true;
        }
        return result;
    }

    /**
     * 初始化回复文本消息
     * @param fromUserName 接收方账号(收到的OpenId)
     * @param toUserName 开发者微信号
     * @return
     */
    private TextMessage initRespTextMessage(String fromUserName, String toUserName){
        // 回复文本消息
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setFuncFlag(0);
        return textMessage;
    }

    /**
     * 初始化图文消息
     * @param fromUserName 接收方账号(收到的OpenId)
     * @param toUserName 开发者微信号
     * @return
     */
    private NewsMessage initRespNewsMessage(String fromUserName, String toUserName){
        // 创建图文消息
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        newsMessage.setFuncFlag(0);
        return newsMessage;
    }

    /**
     * 触发监控事件事件
     * @param fromUserName
     * @param toUserName
     * @param requestMap
     * @return
     */
    private Object monitorEventTrigger(String fromUserName, String toUserName, Map<String,String> requestMap){
        TextMessage textMessage = initRespTextMessage(fromUserName,toUserName);
        String eventType = requestMap.get("Event");
        if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
            textMessage.setContent(subscribeEvent());
        }
        return textMessage;
    }

    /**
     * 关注事件回复
     * @return
     */
    private String subscribeEvent(){
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎关注崋崽生活屋！在这里你可以：\n");
        sb.append("1、叫爸爸！\n");
        sb.append("2、叫爸爸！\n");
        sb.append("谢谢！");
        return sb.toString();
    }

    /**
     * 自动回复文本
     * @param fromUserName
     * @param toUserName
     * @param requestMap
     * @return
     */
    private Object automaticTextReply(String fromUserName, String toUserName, Map<String,String> requestMap){
        TextMessage textMessage = initRespTextMessage(fromUserName,toUserName);
        // 接收文本消息内容
        String content = requestMap.get("Content");
        //如果用户发送表情，则回复同样表情。
        if (isQqFace(content)) {
            textMessage.setContent(content);
            return textMessage;
        } else {
            switch (content){
                default: {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("叫爸爸！叫爸爸！");
                        /*buffer.append("您好，我是小8，请回复数字选择服务：").append("\n\n");
                        buffer.append("11 可查看测试单图文").append("\n");
                        buffer.append("12  可测试多图文发送").append("\n");
                        buffer.append("13  可测试网址").append("\n");

                        buffer.append("或者您可以尝试发送表情").append("\n\n");
                        buffer.append("回复“1”显示此帮助菜单").append("\n");*/
                    String respContent = String.valueOf(buffer);
                    textMessage.setContent(respContent);
                    return textMessage;
                }
            }
        }
    }
}
