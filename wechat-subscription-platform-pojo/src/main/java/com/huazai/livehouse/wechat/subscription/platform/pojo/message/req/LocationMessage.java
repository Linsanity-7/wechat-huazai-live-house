package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;

import java.io.Serializable;

/**
 * @apiNote : 地理位置消息
 * @author        :林尚华
 * @date    : 2018/12/29 14:11
 */
public class LocationMessage extends BaseMessage implements Serializable {
    /**
     * 纬度
     */
    private String locationX;
    /**
     * 经度
     */
    private String locationY;
    /**
     * 地图缩放大小
     */
    private String scale;
    /**
     * 地理位置信息
     */
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }
}
