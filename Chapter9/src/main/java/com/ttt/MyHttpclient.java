package com.ttt;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyHttpclient {

    @Test
    public void Test1() throws IOException {



        String result;
        String uri = "http://192.168.2.168:8000/biz/app/user/login/login?phone=18398932805&password=a1111111&source=android&equipment=and-ffffffff-e978-d445-ffff-ffffef05ac4a";
//        HttpGet get = new HttpGet("http://192.168.2.168:8000/biz/app/user/login/login?phone=18398932805&password=a1111111&source=android&equipment=and-ffffffff-e978-d445-ffff-ffffef05ac4a");
        //这个是用来执行get方法的
        HttpPost post = new HttpPost("http://192.168.2.168:8000/biz/app/user/login/login?phone=18398932805&password=a1111111&source=android&equipment=and-ffffffff-e978-d445-ffff-ffffef05ac4a");
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        JSONObject object = JSONObject.parseObject(result);
        String msg = object.getString("msg");
        int code = object.getIntValue("code");

        FileWriter fstream = new FileWriter("D:\\AutoTest\\AutoTest\\Chapter9\\result.csv",true);
        BufferedWriter out =new BufferedWriter(fstream);
//        out.write(vars.get("token")+","+ vars.get("userid")+","+ vars.get("phone"));
        out.write(msg+","+code+","+result+","+uri);
        out.write(System.getProperty("line.separator"));
        out.close();
        fstream.close();

    }
}
