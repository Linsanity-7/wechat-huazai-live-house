package com.huazai.livehouse.wechat.subscription.platform.pojo.https.req;

import java.io.Serializable;
import java.util.List;

/**
 * 一级菜单对象
 */
public class Button implements Serializable {
    /**
     * 菜单标题
     */
    private String name;
    /**
     * 二级菜单数组
     */
    private List<SubButton> sub_button;
    /**
     * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
     */
    private String type;
    /**
     * 菜单KEY值，用于消息接口推送，不超过128字节(click等点击类型必须)
     */
    private String key;
    /**
     * 网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url。(view、miniprogram类型必须)
     */
    private String url;
    /**
     * 调用新增永久素材接口返回的合法media_id(media_id类型和view_limited类型必须)
     */
    private String media_id;
    /**
     * 小程序的appid（仅认证公众号可配置，miniprogram类型必须）
     */
    private String appid;
    /**
     * 小程序的页面路径(miniprogram类型必须)
     */
    private String pagepath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<SubButton> sub_button) {
        this.sub_button = sub_button;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    @Override
    public String toString() {
        return "Button{" +
                "name='" + name + '\'' +
                ", sub_button=" + sub_button +
                ", type='" + type + '\'' +
                ", key='" + key + '\'' +
                ", url='" + url + '\'' +
                ", media_id='" + media_id + '\'' +
                ", appid='" + appid + '\'' +
                ", pagepath='" + pagepath + '\'' +
                '}';
    }
}
