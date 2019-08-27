package com.order.detile.controller;

import com.order.detile.service.MyRedisConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestMyRedisConfigController {
    @Resource(name = "myRedisConfigService")
    MyRedisConfigService myRedisConfigService;
    @RequestMapping("/testRedisTemplate")
    public void testRedisTemplate() {
        myRedisConfigService.testString();
    }
}
