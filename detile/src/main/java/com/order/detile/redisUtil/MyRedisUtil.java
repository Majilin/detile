package com.order.detile.redisUtil;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class MyRedisUtil {
    @Resource(name="redisTemplate")
    RedisTemplate redisTemplate;

    /***
     * 设置redis中的键-值，并设置失效时间
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key,Object value,long time){
        try {
            redisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
        }catch (Exception e){
           return false;
        }
        return true;
    }

    /***
     * 根据键获取redis中对应的值
     * @param key
     * @return
     */
    public Object get(String key){
        Object obj=redisTemplate.opsForValue().get(key);
        if(obj!=null){
            return  obj;
        }else{
            return null;
        }
    }

    /***
     * 将数据放入set缓存中，可以放入多个
     * @param key
     * @param values
     * @return
     */
    public boolean put(String key,Object ...values){
        try {
            redisTemplate.opsForSet().add(key,values);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }

    /***
     * 根据key值获得对应set的所有值
     * @param key
     * @return
     */
    public Set<Object> getSetAll(String key){
        try{
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    /***
     * 删除对应key的set中的一个或多个value值
     * @param key
     * @param values
     * @return
     */
    public long setRemove(String key,Object ...values){
        try{
            long count=redisTemplate.opsForSet().remove(key,values);
            return  count;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
