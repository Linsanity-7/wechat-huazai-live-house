package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;

import java.io.Serializable;

/**
 * @apiNote :链接消息
 * @author        :林尚华
 * @date    : 2018/12/29 14:09
 */
public class LinkMessage extends BaseMessage implements Serializable {
    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息描述
     */
    private String description;
    /**
     * 消息链接
     */
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
