package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;


/**
 * @apiNote :链接消息
 * @author        :林尚华
 * @date    : 2018/12/29 14:09
 */
public class LinkMessage extends BaseMessage{
    /**
     * 消息标题
     */
    private String Title;
    /**
     * 消息描述
     */
    private String Description;
    /**
     * 消息链接
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

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
