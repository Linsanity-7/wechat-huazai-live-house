package com.huazai.livehouse.wechat.subscription.platform.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * @apiNote :
 * @author        :林尚华
 * @date    : 2019/01/03 16:48
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Class<T> claz;

    public FastJsonRedisSerializer(Class<T> claz){
        super();
        this.claz = claz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {

        if (null == t){
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (null == bytes || bytes.length <= 0){
            return null;
        }
        String str = new String(bytes,DEFAULT_CHARSET);
        return (T)JSON.parseObject(str,claz);
    }
}
