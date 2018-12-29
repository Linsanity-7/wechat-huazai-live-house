package com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp;

import java.io.Serializable;

/**
 * 消息基类（公众账号->普通用户）
 * @author        :林尚华
 * @date    : 2018/12/29 14:32
 */
public class BaseMessage implements Serializable {
    /**
     * 接收方账号(收到的OpenId)
     */
    private String toUserName;
    /**
     * 开发者微信号
     */
    private String fromUserName;
    /**
     * 消息创建时间戳
     */
    private long createTime;
    /**
     * 消息类型
     */
    private String msgType;
    /**
     * 位0x0001被标志时，星标刚收到的消息
     */
    private int funcFlag;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public int getFuncFlag() {
        return funcFlag;
    }

    public void setFuncFlag(int funcFlag) {
        this.funcFlag = funcFlag;
    }
}
