package com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp;

/**
 * @apiNote 图文model
 * @author        :林尚华
 * @date    : 2018/12/29 14:28
 */
public class Article {
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 图片链接
     */
    private String picUrl;
    /**
     * 点击图文消息跳转链接
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
