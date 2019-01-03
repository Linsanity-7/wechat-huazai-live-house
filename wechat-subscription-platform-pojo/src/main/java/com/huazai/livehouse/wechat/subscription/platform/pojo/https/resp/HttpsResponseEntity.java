package com.huazai.livehouse.wechat.subscription.platform.pojo.https.resp;

import java.io.Serializable;

/**
 * 上海美市科技有限公司开发部
 *
 * @author        :林尚华
 * @date    : 2019/01/03 19:15
 * @Description:
 */
public class HttpsResponseEntity<T> implements Serializable {

    private int status;

    private T responseBody;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

    public HttpsResponseEntity(int status, T responseBody) {
        this.status = status;
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "HttpsResponseEntity{" +
                "status=" + status +
                ", responseBody=" + responseBody +
                '}';
    }
}
