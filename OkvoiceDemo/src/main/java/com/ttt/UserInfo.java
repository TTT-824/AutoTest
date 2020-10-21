package com.ttt;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.ResourceBundle;

public class UserInfo {

    private ResourceBundle bundle;

    //    依赖登录获取用户信息
    @Test(dependsOnGroups = "login")
    @DataProvider(name = "data")
    public Object[][] testUserInfo() {

        System.out.println("----------");
        return new Object[][]{{"qw"}, {"qwe"}};
    }

    //    /task/newtaskmember/info
    @Test(dataProvider = "token", dataProviderClass = TestLogin.class)
    public void testUserInfo3(String token) throws URISyntaxException, IOException {

//        获取配置文件
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
//        获取url 设置get请求的参数
        URIBuilder uriBuilder = new URIBuilder(bundle.getString("newtaskurl") + bundle.getString("newtaskmeber.info"));
        uriBuilder.addParameter("userId", "57783");
        System.out.println(token);
        //        模拟请求
        HttpGet httpPGet = new HttpGet(uriBuilder.toString());
        System.out.println(uriBuilder.toString()+":请求路径");
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
//        添加参数post消息体上传
//        设置请求头信息
        httpPGet.setHeader("content-type", "application/json;charset=UTF-8");
//        httpPGet.setHeader("Authorization",token);
        httpPGet.addHeader("authorization",token.toString());
        httpPGet.addHeader("source","android");
        System.out.println(httpPGet.toString()+"11111");
//        执行post方法
        HttpResponse execute = defaultHttpClient.execute(httpPGet);
//        获取返回内容
        String s = EntityUtils.toString(execute.getEntity(), "utf-8");
        int statusCode = execute.getStatusLine().getStatusCode();
//        打印返回值和请求状态码
        System.out.println(execute.getAllHeaders());
        System.out.println(s + "\n" + statusCode);
//        断言
//        Assert.assertEquals(code, 200);
    }
}
