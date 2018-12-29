package com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp;

/**
 * 上海美市科技有限公司开发部
 *
 * @author        :林尚华
 * @date    : 2018/12/29 15:31
 * @Description:
 */
public class TextMessage extends BaseMessage{
    /**
     * 回复的消息内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
