package com.huazai.livehouse.wechat.subscription.platform.pojo.https.req;

/**
 * @apiNote : 获取access_token请求类
 * @author        :林尚华
 * @date    : 2019/01/02 17:34
 */
public class AccessTokenRequest extends BaseHttpsRequest{

    private String grantType = "client_credential";

    private String appId;

    private String secret;

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public AccessTokenRequest(String url,String appId, String secret) {
        this.appId = appId;
        this.secret = secret;
        this.url = url;
    }

    public AccessTokenRequest() {
    }

    @Override
    public String toString() {
        return "AccessTokenRequest{" +
                "BaseHttpsRequest{"+
                "url = '" + getUrl() + '\'' +
                "grant_type='" + grantType + '\'' +
                ", appId='" + appId + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
