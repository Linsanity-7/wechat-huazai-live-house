package com.huazai.livehouse.wechat.subscription.platform.pojo.message.req;


/**
 * @apiNote : 音频消息
 * @author        :林尚华
 * @date    : 2018/12/29 14:23
 */
public class VoiceMessage extends BaseMessage{
    /**
     * 媒体id
     */
    private String MediaId;
    /**
     * 语音格式
     */
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
