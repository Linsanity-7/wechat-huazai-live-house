package com.huazai.livehouse.wechat.subscription.platform.pojo.https.req;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义菜单请求对象
 */
public class ButtonRequest implements Serializable {

    private List<Button> button;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "ButtonRequest{" +
                "button=" + button +
                '}';
    }
}
