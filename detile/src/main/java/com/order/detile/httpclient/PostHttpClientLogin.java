package com.order.detile.httpclient;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class PostHttpClientLogin {
    static CookieStore cs;

    public static void main(String[] args) {
        postLogin();//登陆

        user2get();

    }

    private static void user2get() {
        //post模拟登陆传参数

        // CookieStore cookieStore = new BasicCookieStore();// 保存cook的对象
        CookieStore cookieStore=cs;

        HttpClientBuilder builder = HttpClients.custom()
                .disableAutomaticRetries() // 关闭自动处理重定向
                .setRedirectStrategy(new LaxRedirectStrategy());// 利用LaxRedirectStrategy处理POST重定向问题
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        builder.setDefaultCookieStore(cookieStore);// 设置保存cook对象
        CloseableHttpClient httpClient = builder.build();// 获取HttpClient对象

        String url = "http://localhost:8095/user2";
        // String url = "http://localhost:8095/user3?id=3";
        HttpGet httpGet = new HttpGet(url);// 常用post请求方式
        // 设置请求的参数
        httpGet.setConfig(MyRequestConfig.getRequestConfig());

        CloseableHttpResponse response =null;
        // 执行请求
        try {
            response = httpClient.execute(httpGet);
            String rs = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(rs);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void postLogin() {
        //post模拟登陆传参数

        CookieStore cookieStore = new BasicCookieStore();// 保存cook的对象
        HttpClientBuilder builder = HttpClients.custom()
                .disableAutomaticRetries() // 关闭自动处理重定向
                .setRedirectStrategy(new LaxRedirectStrategy());// 利用LaxRedirectStrategy处理POST重定向问题
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        builder.setDefaultCookieStore(cookieStore);// 设置保存cook对象
        CloseableHttpClient httpClient = builder.build();// 获取HttpClient对象

        String url = "http://localhost:8095/login";
        HttpPost httpPost = new HttpPost(url);// 常用post请求方式
        // 设置请求的参数
        httpPost.setConfig(MyRequestConfig.getRequestConfig());


        // 设置post请求传值
        String params = "id=1&name=root";
        StringEntity stringEntity = new StringEntity(params, "UTF-8");
        stringEntity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(stringEntity);// 设置post请求参数及传值
        CloseableHttpResponse response =null;
        // 执行请求
        try {
             response = httpClient.execute(httpPost);
            String rs = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(rs);
            for (Cookie ck : cookieStore.getCookies()) {
                System.out.println("登陆成功cook:"+ck.getName()+ck.getValue());
            }
            cs=cookieStore;//保存登陆成功的cook对象,在项目里面应该是保存的session的一个键

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
