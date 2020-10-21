package com.ttt.testng;

import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.HttpResponse;

import java.net.URISyntaxException;
import java.util.Locale;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ResourceBundle;

public class myutils {

    /*
     * String apihostm 请求地址
     * String apiport    api地址
     * String requestmethod  请求方式
     * String properties 配置文件名称
     * URIBuilder uriBuilder    get请求参数
     * JSONObject jsonObject
     * */

    /*
     * 参数列表
     * */

    private ResourceBundle bundle;
    private URIBuilder uriBuilder;

    public HttpResponse initializeHttp(String properties, String requestmethod, URIBuilder uriBuilder, JSONObject jsonObject) {
//        拼接地址

        bundle = ResourceBundle.getBundle(properties, Locale.CHINA);


//        判断get还是post

        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            if (requestmethod.equals("get")) {
                HttpGet httpGet = new HttpGet(uriBuilder.toString());
            }else {
                HttpPost httpPost = new HttpPost(uriBuilder.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        添加请求参数

//        添加请求header信息

//        返回一个HttpResponse对象

        return true;
    }
}
