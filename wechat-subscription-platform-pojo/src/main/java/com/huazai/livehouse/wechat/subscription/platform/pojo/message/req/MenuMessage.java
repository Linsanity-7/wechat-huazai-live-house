package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;


/**
 * 上海美市科技有限公司开发部
 * @apiNote : 菜单消息
 * @author        :林尚华
 * @date    : 2018/12/29 14:15
 */
public class MenuMessage extends BaseMessage {

    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
