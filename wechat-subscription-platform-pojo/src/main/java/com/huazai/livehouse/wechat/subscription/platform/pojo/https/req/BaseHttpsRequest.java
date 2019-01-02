package com.huazai.livehouse.wechat.subscription.platform.pojo.https.req;

import java.io.Serializable;

/**
 * @apiNote :Https请求基类
 * @author        :林尚华
 * @date    : 2019/01/02 17:31
 */
public class BaseHttpsRequest implements Serializable {
    protected String url;

    protected String accessToken;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "BaseHttpsRequest{" +
                "url='" + url + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
