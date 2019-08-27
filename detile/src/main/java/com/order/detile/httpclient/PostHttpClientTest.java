package com.order.detile.httpclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PostHttpClientTest {

    public static void main(String[] args) {
        //Post方式请求
        //1、获取HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //2、创建连接的方式
        // String url = "http://www.baidu.com";
        String url = "http://localhost:8095/selectuser2all?page=2";
        HttpPost post = new HttpPost(url);
        //3、设置请求方式连接的参数
        post.setConfig(MyRequestConfig.getRequestConfig());

        try {
            //4、执行请求,获取服务器返回的结果
            CloseableHttpResponse entity = client.execute(post);
            String s = EntityUtils.toString(entity.getEntity(), "utf-8");
            ObjectMapper om = new ObjectMapper();
            List<Map<String, Object>> list = om.readValue(s, new TypeReference<List<Map<String, Object>>>() {
            });
            for (Map<String, Object> map : list) {
                System.out.println(map.get("id") + "\t" + map.get("name")+"\t"+map.get("imgpath"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
