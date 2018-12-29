package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;

import java.io.Serializable;

/**
 * @apiNote :图片消息
 * @author        :林尚华
 * @date    : 2018/12/29 14:07
 */
public class ImageMessage extends BaseMessage implements Serializable {
    /**
     * 图片链接
     */
    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
