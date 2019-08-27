package com.order.detile.service;
import com.order.detile.domain.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
@Repository
public class MyRedisConfigService {
    @Resource(name = "redisTemplate2")
    private RedisTemplate redisTemplate;
    public void testString() {
        System.out.println("redis");
        redisTemplate.opsForValue().set("b", "it you know你好");//字符
        // redisTemplate.opsForValue().set("bb", "ityouknow你好",10,TimeUnit.SECONDS);
        System.out.println("hahaha ");
        User u2=new User();
        u2.setName("aaa");
        u2.setSex("men");
        System.out.println(u2);
        redisTemplate.opsForValue().set("objuser",u2);//对象

        Object v = redisTemplate.opsForValue().get("b");
        User u=(User)redisTemplate.opsForValue().get("objuser");
        System.out.println(v + "===--"+u.getName());
    }


}
