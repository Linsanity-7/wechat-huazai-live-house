package com.huazai.livehouse.wechat.subscription.platform.pojo.https.resp;

import java.io.Serializable;

/**
 * 上海美市科技有限公司开发部
 *
 * @author        :林尚华
 * @date    : 2019/01/02 17:50
 * @Description:
 */
public class AccessTokenResp implements Serializable {

    private String access_token;

    private String expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public AccessTokenResp(String access_token, String expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
    }

    public AccessTokenResp() {
    }

    @Override
    public String toString() {
        return "AccessTokenResp{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                '}';
    }
}
