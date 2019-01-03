package com.huazai.livehouse.wechat.subscription.platform.service.impl;

import com.huazai.livehouse.wechat.subscription.platform.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 上海美市科技有限公司开发部
 *
 * @author        :林尚华
 * @date    : 2019/01/03 18:40
 * @Description:
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean existsKey(String key) {
        return false;
    }

    @Override
    public void renameKey(String oldKey, String newKey) {

    }

    @Override
    public boolean renameKeyNotExist(String oldKey, String newKey) {
        return false;
    }

    @Override
    public void deleteKey(String key) {

    }

    @Override
    public void deleteKey(String... keys) {

    }

    @Override
    public void deleteKey(Collection<String> keys) {

    }

    @Override
    public void expireKey(String key, long time, TimeUnit timeUnit) {

    }

    @Override
    public void expireKeyAt(String key, Date date) {

    }

    @Override
    public long getKeyExpire(String key, TimeUnit timeUnit) {
        return 0;
    }

    @Override
    public void persistKey(String key) {

    }

    @Override
    public void hashOperationsSeve(String hashKey, String key, Object object) {

    }

    @Override
    public void valueOperationsSave(String key, Object object) {
        redisTemplate.opsForValue().set(key, object);
    }
}
