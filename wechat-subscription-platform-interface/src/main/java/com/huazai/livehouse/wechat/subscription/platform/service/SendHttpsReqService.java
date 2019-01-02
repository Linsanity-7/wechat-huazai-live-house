package com.huazai.livehouse.wechat.subscription.platform.service;

/**
 * @apiNote 发送https请求
 * @author        :林尚华
 * @date    : 2019/01/02 16:46
 */
public interface SendHttpsReqService<T,E> {
    /**
     * 发送https的GET请求
     * @param e 请求对象
     * @return
     */
    T doGet(E e);
}
