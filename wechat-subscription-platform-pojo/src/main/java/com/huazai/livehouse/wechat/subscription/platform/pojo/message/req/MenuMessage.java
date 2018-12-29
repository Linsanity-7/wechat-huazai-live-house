package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;

import java.io.Serializable;

/**
 * 上海美市科技有限公司开发部
 * @apiNote : 菜单消息
 * @author        :林尚华
 * @date    : 2018/12/29 14:15
 */
public class MenuMessage extends BaseMessage implements Serializable {

    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
