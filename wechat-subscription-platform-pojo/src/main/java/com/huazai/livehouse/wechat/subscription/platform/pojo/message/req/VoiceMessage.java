package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;

import java.io.Serializable;

/**
 * @apiNote : 音频消息
 * @author        :林尚华
 * @date    : 2018/12/29 14:23
 */
public class VoiceMessage extends BaseMessage implements Serializable {
    /**
     * 媒体id
     */
    private String mediaId;
    /**
     * 语音格式
     */
    private String format;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
