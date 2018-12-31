package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;


/**
 * @apiNote :文本消息
 * @author        :林尚华
 * @date    : 2018/12/29 14:16
 */
public class TextMessage extends BaseMessage{
    /**
     * 消息内容
     */
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
