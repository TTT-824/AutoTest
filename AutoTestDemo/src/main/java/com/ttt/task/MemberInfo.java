package com.ttt.task;

import com.ttt.login.Login;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.Asserts;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MemberInfo {

    private String token;
    Object[][] objects;
    ResourceBundle bundle;

    /*
    * 获取用户基本信息
    * */
    @Test(dataProvider = "haha",dataProviderClass = Login.class)
    public void infos1(String haha) throws URISyntaxException, IOException {
        System.out.println("Test Item:获取成员信息");
        /*
         *DefaultHttpClient 原方法已废弃
         * HttpClientBuilder.create().build()   替代新方法
         * */
        HttpClient httpClient = HttpClientBuilder.create().build();

        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        URIBuilder uriBuilder = new URIBuilder(bundle.getString("newtaskurl") + bundle.getString("get.newtask.member.info"));
        uriBuilder.addParameter("userId","57786");

        HttpGet httpGet = new HttpGet(uriBuilder.toString());

        httpGet.addHeader("authorization",token = haha);
        httpGet.addHeader("source","android");
        httpGet.addHeader("content-type","application/json;charset=UTF-8");

        HttpResponse response = httpClient.execute(httpGet);

        String response_String = EntityUtils.toString(response.getEntity());

        System.out.println(response_String);

        JSONObject json = new JSONObject(response_String);



        Assert.assertEquals(json.get("msg").toString(),"success");
    }
}
