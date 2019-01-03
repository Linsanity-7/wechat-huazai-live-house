package com.huazai.livehouse.wechat.subscription.platform.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @apiNote :redis接口
 * @author        :林尚华
 * @date    : 2019/01/03 17:11
 */
public interface RedisService {
    /**
     * 默认过期时长，单位秒
     */
    long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**
     * 不设置过期时长
     */
    long NOT_EXPIRE = -1;

    /**
     * 判断该key是否存在
     * @param key key
     * @return boolean
     */
    boolean existsKey(String key);

    /**
     * 重命名key，如果newKey已经存在，则newKey的原值被覆盖
     * @param oldKey 旧key
     * @param newKey 新key
     */
    void renameKey(String oldKey, String newKey);

    /**
     * newKey不存在时才重命名
     * @param oldKey oldKey
     * @param newKey newKey
     * @return 修改成功返回true
     */
    boolean renameKeyNotExist(String oldKey, String newKey);

    /**
     * 删除key
     * @param key key
     */
    void deleteKey(String key);

    /**
     * 删除多个key
     * @param keys keys
     */
    void deleteKey(String ... keys);

    /**
     * 删除key的集合
     * @param keys keys
     */
    void deleteKey(Collection<String> keys);

    /**
     * 设置key的生命周期
     * @param key key
     * @param time time
     * @param timeUnit timeUnit
     */
    void expireKey(String key, long time, TimeUnit timeUnit);

    /**
     * 指定key再指定的日期过期
     * @param key key
     * @param date date
     */
    void expireKeyAt(String key, Date date);

    /**
     * 查询key的生命周期
     * @param key key
     * @param timeUnit timeUnit
     * @return 生命周期（单位：毫秒）
     */
    long getKeyExpire(String key, TimeUnit timeUnit);

    /**
     * 将key设置为永久有效
     * @param key key
     */
    void persistKey(String key);

    /**
     * 对hash类型的数据进行操作
     * @param hashKey
     * @param key
     * @param object
     * @return
     */
    void hashOperationsSeve(String hashKey, String key, Object object);

    /**
     * 对redis字符串类型数据操作
     * @param key
     * @param object
     */
    void valueOperationsSave(String key,Object object);
}
