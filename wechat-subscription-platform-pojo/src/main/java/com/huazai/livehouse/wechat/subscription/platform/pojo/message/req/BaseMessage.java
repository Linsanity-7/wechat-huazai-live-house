package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;

import java.io.Serializable;

/**
 * @apiNote : 消息基类
 * @author        :林尚华
 * @date    : 2018/12/29 14:02
 */
public class BaseMessage implements Serializable {
    /**
     * 开发者账号
     */
    private String ToUserName;

    /**
     * 发送方账号
     */
    private String FromUserName;
    /**
     * 消息创建时间戳
     */
    private long CreateTime;
    /**
     * 消息类型
     */
    private String MsgType;
    /**
     * 消息id，64位整型数
     */
    private long MsgId;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
