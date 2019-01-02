package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;


/**
 * @apiNote :图片消息
 * @author        :林尚华
 * @date    : 2018/12/29 14:07
 */
public class ImageMessage extends BaseMessage{
    /**
     * 图片链接
     */
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
