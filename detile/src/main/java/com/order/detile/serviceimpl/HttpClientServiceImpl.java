package com.order.detile.serviceimpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.detile.service.HttpClientService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HttpClientServiceImpl implements HttpClientService {


    @Override
    public List<Map<String, Object>> getHttpClient(String uri) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(uri);
        List<Map<String,Object>> list=new ArrayList<>();
        try {
            CloseableHttpResponse data= client.execute(get);
            String str= EntityUtils.toString(data.getEntity(),"utf-8");
            ObjectMapper om=new ObjectMapper();
            list=om.readValue(str,new TypeReference<List<Map<String,Object>>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
