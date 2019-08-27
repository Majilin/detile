package com.order.detile.serviceimpl;

import com.order.detile.myRedisConfig.MyRedisTemplate;
import com.order.detile.myproperties.MyProperties;
import com.order.detile.service.TestTelService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TestTelServiceImpl implements TestTelService {
    @Resource(name = "myProperties")
    MyProperties myProperties;

    @Resource(name = "myRedisTemplate")
    MyRedisTemplate myRedisTemplate;


    @Override
    public boolean sendtelnum(String telnum) {
        //生成一个4位的随机数字
        int r = (int) (Math.random() * 9000) + 1000; //0.00001
        //发送短信到手机号码

        //存入redis里面，时间为30秒
        myRedisTemplate.set("tel:"+telnum,r+"",myProperties.getSeconds());
        return true;
    }
}
