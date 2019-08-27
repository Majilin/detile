package com.order.detile.controller;

import com.order.detile.myproperties.MyProperties;
import com.order.detile.service.TestTelService;
import com.order.detile.serviceimpl.TestTelServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestTimeController {
    @Resource(name = "myProperties")
    MyProperties myProperties;
    @Resource(name = "testTelServiceImpl")
    TestTelService testTelService;
    @RequestMapping("/sendtelnum")
    ///倒计时
    public int sendtelnum(String telnum ){
      boolean b= testTelService.sendtelnum(telnum);
      if(b){
          return myProperties.getSeconds();//自定义属性文件的属性值
      }
        return -1;
    }
}
