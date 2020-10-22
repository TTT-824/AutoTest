package com.ttt;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.ResourceBundle;

@Test(groups = "login")
public class TestLogin {

    //    save变量
    private String result;
    private ResourceBundle bundle;

    @Test
    @DataProvider(name = "token")
    public Object[][] withTestLogin() throws IOException, URISyntaxException {
//        获取配置文件
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
//        获取url 设置get请求的参数
        URIBuilder uriBuilder = new URIBuilder(bundle.getString("devurl") + bundle.getString("user.login"));
        uriBuilder.addParameter("phone", "18398932805");
        uriBuilder.addParameter("password", "a1111111");
        uriBuilder.addParameter("source", "android");
//        模拟请求
        HttpPost httpPost = new HttpPost(uriBuilder.toString());
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
//        添加参数post消息体上传
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone", "18398932805");
        jsonObject.put("password", "wyy18398932805");
        jsonObject.put("source", "android");
        System.out.println(jsonObject.toString());
//        设置请求头信息
        httpPost.setHeader("content-type", "application/json;charset=UTF-8");
//        设置token
        /*
        * httpPost.setHeader("authorization", "token");
        * */
//        设置参数到方法中
        StringEntity stringEntity = new StringEntity(jsonObject.toString(), "utf-8");
        httpPost.setEntity(stringEntity);
//        设置cookies信息
        /*
        defaultHttpClient.setCookieStore(cookieStore);
        * */
//        执行post方法
        HttpResponse execute = defaultHttpClient.execute(httpPost);
//        获取返回内容
        String s = EntityUtils.toString(execute.getEntity(), "utf-8");
        int statusCode = execute.getStatusLine().getStatusCode();
//        打印返回值和请求状态码
        System.out.println(s + "\n" + statusCode);
//        处理结果  判断返回值是否符合预期
        JSONObject jsonObject1 = new JSONObject(s);
//        具体判断 并 返回结果的值
        String msg = (String) jsonObject1.get("msg");
        int code = jsonObject1.getInt("code");
//        获取data中的数据
        String data = String.valueOf(jsonObject1.get("data"));
        JSONObject jsonObject2 = new JSONObject(data);
        Object token = jsonObject2.get("token");
//        获取userid
        Object userid = jsonObject2.get("id");

        System.out.println(token);
        System.out.println(msg);
        System.out.println(code);
//        断言
        Assert.assertEquals(code, 200);
        Assert.assertEquals(msg, "操作成功");

        return new Object[][]{
                {String.valueOf(token)}
//                ,{String.valueOf(userid)}
        };
    }
}
