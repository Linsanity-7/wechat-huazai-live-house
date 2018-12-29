package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;

import java.io.Serializable;

/**
 * @apiNote :文本消息
 * @author        :林尚华
 * @date    : 2018/12/29 14:16
 */
public class TextMessage extends BaseMessage implements Serializable {
    /**
     * 消息内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
