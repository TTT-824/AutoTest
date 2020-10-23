package com.ttt.task;

import com.ttt.login.Login;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.ResourceBundle;

public class TaskList {
    private String token;
    Object[][] objects;
    ResourceBundle bundle;

    /*
     * 获取任务大厅列表
     * */
    @Test(dataProvider = "haha",dataProviderClass = Login.class)
    public void infos1(String haha) throws URISyntaxException, IOException {
        System.out.println("Test Item:获取任务大厅列表");
        /*
         *DefaultHttpClient 原方法已废弃
         * HttpClientBuilder.create().build()   替代新方法
         * */
        HttpClient httpClient = HttpClientBuilder.create().build();

        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        URIBuilder uriBuilder = new URIBuilder(bundle.getString("newtaskurl") + bundle.getString("post.newtask.list"));

        HttpPost httpPost = new HttpPost(uriBuilder.toString());

        httpPost.addHeader("authorization",token = haha);
        httpPost.addHeader("source","android");
        httpPost.addHeader("content-type","application/json;charset=UTF-8");

        JSONObject jsonpost = new JSONObject();
        jsonpost.put("isOnline","null");
        jsonpost.put("keywords","null");
        jsonpost.put("pageNum","1");
        jsonpost.put("pageSize","10");
        jsonpost.put("startTime","null");
        jsonpost.put("stopTime","null");
        jsonpost.put("type","null");
        jsonpost.put("userId","57786");

        httpPost.setEntity(new StringEntity(jsonpost.toString(),"utf-8"));

        HttpResponse response = httpClient.execute(httpPost);

        String response_String = EntityUtils.toString(response.getEntity());

        System.out.println(response_String);

        JSONObject json = new JSONObject(response_String);

        Assert.assertEquals(json.get("msg").toString(),"success");
    }
}
