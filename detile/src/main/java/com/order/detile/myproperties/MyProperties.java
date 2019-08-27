package com.order.detile.myproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/*
* 属性文件类中要用到的属性必须加载Get和Set方法
*
* */
@Component
@PropertySource("classpath:myproperties.properties")//resources  ->  myproperties.properties 文件
@ConfigurationProperties(prefix = "myproperties")//resources  ->  myproperties.properties的前缀
public class MyProperties {
    private  int pageSize;//每页的条数
    private int seconds;

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
