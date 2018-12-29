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
    private String developerAccount;

    /**
     * 发送方账号
     */
    private String sendAccount;
    /**
     * 消息创建时间戳
     */
    private long createTime;
    /**
     * 消息类型
     */
    private String msgType;
    /**
     * 消息id，64位整型数
     */
    private long msgId;

    public String getDeveloperAccount() {
        return developerAccount;
    }

    public void setDeveloperAccount(String developerAccount) {
        this.developerAccount = developerAccount;
    }

    public String getSendAccount() {
        return sendAccount;
    }

    public void setSendAccount(String sendAccount) {
        this.sendAccount = sendAccount;
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

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
