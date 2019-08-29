package com.order.detile.myproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "goods")
@PropertySource("classpath:UriProperties.properties")
public class GoodsProperties {
    private String goodsUri;
    public String getGoodsUri() {
        return goodsUri;
    }
    public void setGoodsUri(String goodsUri) {
        this.goodsUri = goodsUri;
    }
}
