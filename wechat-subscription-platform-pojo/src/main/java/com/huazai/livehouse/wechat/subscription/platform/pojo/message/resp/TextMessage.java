package com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp;

import java.io.Serializable;

/**
 * 上海美市科技有限公司开发部
 *
 * @author        :林尚华
 * @date    : 2018/12/29 15:31
 * @Description:
 */
public class TextMessage extends BaseMessage implements Serializable{
    /**
     * 回复的消息内容
     */
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
