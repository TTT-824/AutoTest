package com.ttt.httpclient;

import org.json.JSONObject;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        // 创建 HashMap 对象 Sites
        HashMap<String, String> Sites = new HashMap<String, String>();
        // 添加键值对
        Sites.put("we", "Google");
        Sites.put("we1", "Runoob");
        Sites.put("vf", "Taobao");
        Sites.put("er", "Zhihu");
        // 输出 key 和 value
        for (String i : Sites.keySet()) {
            System.out.println("key: " + i + " value: " + Sites.get(i));
        }
//http://api.okyuyin.com/biz/app/user/login/login?phone=18398932805&password=wyy18398932805&source=android
        HttpClientApi httpClientApi = new HttpClientApi();
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("phone","18398932805");
        hashMap.put("password","wyy18398932805");
        hashMap.put("source","android");

        httpClientApi.setToken("saadadaddadas");

        System.out.println(httpClientApi.doPoster("http://api.oyuyin.com/biz/app/user/login/login", hashMap));


        httpClientApi.doPost("http://api.oyuyin.com/biz/app/user/login/login",new JSONObject("{}"));
    }
}
