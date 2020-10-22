package com.ttt.testng;

import com.alibaba.fastjson.JSONObject;
//import com.sun.deploy.net.HttpResponse;
import org.apache.http.HttpResponse;

import java.net.URISyntaxException;
import java.util.Locale;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ResourceBundle;

public class myutils {

    /*
     * String requestmethod  请求方式
     * String properties 配置文件名称
     * URIBuilder uriBuilder    get请求参数
     * JSONObject jsonObject    post消息体数据
     * String token token信息
     * 配置文件名称,请求方式,uriBuilder-api地址，jsonObject-post方法的参数,token
     * */

    /*
     * 参数列表
     * */

    private ResourceBundle bundle;
    private URIBuilder uriBuilder;
    private HttpResponse execute;

    public HttpResponse initializeHttp(String properties, String requestmethod, URIBuilder uriBuilder, JSONObject jsonObject,String token) {
//        拼接地址

        bundle = ResourceBundle.getBundle(properties, Locale.CHINA);


//        判断get还是post

        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            if (requestmethod.equals("get")) {
//                get
                HttpGet httpGet = new HttpGet(uriBuilder.toString());
                httpGet.setHeader("content-type", "application/json;charset=UTF-8");
                httpGet.addHeader("authorization",token);
                httpGet.addHeader("source","android");
//        执行get方法
                execute = defaultHttpClient.execute(httpGet);
            }else {
//                post
                HttpPost httpPost = new HttpPost(uriBuilder.toString());
                //        设置参数到方法中
                StringEntity stringEntity = new StringEntity(jsonObject.toString(), "utf-8");
                //        设置请求头信息
                httpPost.setHeader("content-type", "application/json;charset=UTF-8");
                httpPost.addHeader("authorization",token);
                httpPost.addHeader("source","android");
//        执行post方法
                execute = defaultHttpClient.execute(httpPost);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        添加请求参数

//        添加请求header信息

//        返回一个HttpResponse对象

        return execute;
    }
}
