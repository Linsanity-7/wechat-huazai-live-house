package com.huazai.livehouse.wechat.subscription.platform.service.impl;

import com.huazai.livehouse.wechat.subscription.platform.service.RedisService;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
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
        return redisTemplate.hasKey(key);
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
        redisTemplate.delete(key);
    }

    @Override
    public void deleteKey(String... keys) {
        for (String key : keys){
            redisTemplate.delete(key);
        }
    }

    @Override
    public void deleteKey(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    @Override
    public void expireKey(String key, long time, TimeUnit timeUnit) {
        redisTemplate.expire(key, time, timeUnit);
    }

    @Override
    public void expireKeyAt(String key, Date date) {

    }

    @Override
    public long getKeyExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key, timeUnit);
    }

    @Override
    public void persistKey(String key) {

    }

    @Override
    public void saveHashOperations(String hashKey, String key, Object object) {
        redisTemplate.opsForHash().put(key,hashKey,object);
    }

    @Override
    public void saveValueOperations(String key, Object object) {
        redisTemplate.opsForValue().set(key, object);
    }

    @Override
    public Object getValueOperations(Object key) {
        return redisTemplate.opsForValue().get(key);
    }
}
