package com.bin.login.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {


    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setValue(RedisTemplate<String, Object> redisTemplate){
        RedisUtil.redisTemplate = redisTemplate;
    }

    /**
     * 设置 Redis 的键值
     * @param key
     * @param value
     * @return
     */
    public static boolean setKeyAndValue(String key, Object value){
        try{
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 存储指定时间的键值对
     * @param key
     * @param value
     * @param time
     * @param timeUnit
     * @return
     */
    public static boolean setKeyAndValueTime(String key, Object value, long time, TimeUnit timeUnit){
        try{
            redisTemplate.opsForValue().set(key, value, time, timeUnit);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static Object getValue(String key){
        try{
            Object o = redisTemplate.opsForValue().get(key);
            return o;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断 Redis 是否存在该键
     * @param key
     * @return
     */
    public static boolean isExistKey(String key){
        try{
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除某键
     * @param key
     * @return
     */
    public static boolean deleteKey(String key){
        try{
            return redisTemplate.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取某键的过期时间
     * @param key
     * @return
     */
    public static long getExpireTime(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }


    /**
     * 设置某键的过期时间
     * @param key
     * @param time
     * @param timeUnit
     * @return
     */
    public static boolean setExpireTime(String key, long time, TimeUnit timeUnit){
        try{
            return redisTemplate.expire(key, time, timeUnit);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
