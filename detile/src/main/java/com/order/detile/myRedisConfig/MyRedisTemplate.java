package com.order.detile.myRedisConfig;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
@Repository
public class MyRedisTemplate {
    @Resource(name = "redisTemplate")
    RedisTemplate redisTemplate;

    public boolean set(String key, String value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        return true;
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
