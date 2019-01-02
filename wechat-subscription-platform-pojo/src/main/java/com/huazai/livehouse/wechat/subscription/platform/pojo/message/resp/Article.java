package com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp;

import java.io.Serializable;

/**
 * @apiNote 图文model
 * @author        :林尚华
 * @date    : 2018/12/29 14:28
 */
public class Article implements Serializable{
    /**
     * 标题
     */
    private String Title;
    /**
     * 描述
     */
    private String Description;
    /**
     * 图片链接
     */
    private String PicUrl;
    /**
     * 点击图文消息跳转链接
     */
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
