package com.order.detile.httpclient;

import org.apache.http.client.config.RequestConfig;

public class MyHttpClientConfig {
    /***
     * 设置返回请求参数requestConfig对象
     */
    private static RequestConfig myClientConfig=RequestConfig.custom().setSocketTimeout(45000).setConnectTimeout(45000).setConnectionRequestTimeout(45000).build();
    public static RequestConfig getMyClientConfig(){
        return  myClientConfig;
    }
}
