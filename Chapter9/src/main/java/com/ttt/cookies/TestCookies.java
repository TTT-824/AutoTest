package com.ttt.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestCookies {
    private String url;
    private String result;
    private ResourceBundle bundle;
    private CookieStore cookieStore;

//    绑定配置文件
    @BeforeTest
    public void beforTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
    }

//    代码逻辑
    @Test
    public void testCookies() throws IOException {
        url = bundle.getString("testurl");
        HttpGet httpGet = new HttpGet(url+bundle.getString("getcookiesuri"));
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = httpClient.execute(httpGet);
        result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
        System.out.println(result);

//     获取cookies信息
        cookieStore = httpClient.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        for (Cookie tmp:cookies) {
            System.out.println("cookies-name="+tmp.getName()+"\n"+"cookies-value="+tmp.getValue());
        }
    }

    @Test(dependsOnMethods = {"testCookies"})
    public void testCookies2() throws IOException {
        String uri = this.url+bundle.getString("getcookiesuri2");
        HttpGet httpGet = new HttpGet(uri);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
//        设置cookies
        defaultHttpClient.setCookieStore(cookieStore);
        HttpResponse execute = defaultHttpClient.execute(httpGet);
//        获取响应状态码
        int statusCode = execute.getStatusLine().getStatusCode();
//        打印获取到的信息
        System.out.println("testCookies with statuscode:"+statusCode);
//        判断执行结果
        if (statusCode == 200){
            String s = EntityUtils.toString(execute.getEntity(), "utf-8");
            System.out.println(s);
        }
    }
}
