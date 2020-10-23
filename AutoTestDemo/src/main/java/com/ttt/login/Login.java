package com.ttt.login;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.ResourceBundle;


@Test(groups = "api")
public class Login {

    Object[][] objects;
    ResourceBundle bundle;

    @DataProvider(name = "haha")
    @Test
    public Object[][] logins() throws URISyntaxException, IOException {
        System.out.println("Test Item:登录");
        /*
         *DefaultHttpClient 原方法已废弃
         * HttpClientBuilder.create().build()   替代新方法
         * */
        HttpClient httpClient = HttpClientBuilder.create().build();

        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        URIBuilder uriBuilder = new URIBuilder(bundle.getString("testurl") + bundle.getString("post.user.login"));
        uriBuilder.addParameter("phone","18398932805");
        uriBuilder.addParameter("password","a1111111");
        uriBuilder.addParameter("source","android");

        HttpPost httpPost = new HttpPost(uriBuilder.toString());

        HttpResponse response = httpClient.execute(httpPost);

        String response_String = EntityUtils.toString(response.getEntity());

        System.out.println(response_String);

        JSONObject json = new JSONObject(response_String);

        String data = String.valueOf(json.get("data"));

        String token = String.valueOf(new JSONObject(data).get("token"));

        Assert.assertEquals(json.get("msg").toString(),"操作成功");

        objects = new Object[][]{{token}};

        return objects;
    }
}
