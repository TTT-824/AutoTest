package com.ttt.httpclient;

import com.sun.javafx.fxml.builder.URLBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class HttpClientApi {

    URIBuilder builder; //url
    JSONObject json;    //json
    DefaultHttpClient defaultClient;    //http
    HttpGet httpGet;    //httpget
    HttpPost httpPost;    //httppost
    CloseableHttpResponse execute;  //execute
    String result;  //result value

    //    header info
    private String content_type = "application/json;charset=UTF-8";
    private String token = "";
    private String source = "";


    //    HTTP GET request
    public String doGet(String url, HashMap<String, String> value) {

//        1 verify url
        if (Objects.isNull(url)) {
            return "url is null";
        }

//        2 verify value
        try {
            builder = new URIBuilder(url);
            for (String tmp : value.keySet()) {
                builder.addParameter(tmp, value.get(tmp));
            }
        } catch (NullPointerException | URISyntaxException e) {
            System.out.println(e);
        }

//        3 create http request
        defaultClient = new DefaultHttpClient();
        httpGet = new HttpGet(builder.toString());

//        4 set header info
        if (source.equals("")) {
            httpGet.addHeader("content-type", content_type);
            httpGet.addHeader("authorization", token);
        } else {
            httpGet.addHeader("content-type", content_type);
            httpGet.addHeader("authorization", token);
            httpGet.addHeader("source", source);
        }

//        5 execute request
        try {
            execute = defaultClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        6 gain result info
        try {
//            http status code  EG:200
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                return "执行失败:\t" + statusCode;
            }
            String ent = EntityUtils.toString(execute.getEntity(), "utf-8");
            result = ent;
        } catch (IOException e) {
            e.printStackTrace();
        }
//        result httpresponse (String)
        return result;
    }

    //    HTTP POST requester
    public String doPoster(String url, HashMap<String, String> value) {

//        1 verify url
        if (Objects.isNull(url)) {
            return "url is null";
        }

//        2 verify value
        try {
            builder = new URIBuilder(url);
            for (String tmp : value.keySet()) {
                builder.addParameter(tmp, value.get(tmp));
            }
        } catch (NullPointerException | URISyntaxException e) {
            System.out.println(e);
        }

//        3 create http request
        defaultClient = new DefaultHttpClient();
        httpPost = new HttpPost(builder.toString());

//        4 set header info
        if (source.equals("")) {
            httpPost.addHeader("content-type", content_type);
            httpPost.addHeader("authorization", token);
        } else {
            httpGet.addHeader("content-type", content_type);
            httpGet.addHeader("authorization", token);
            httpGet.addHeader("source", source);
        }

//        5 execute request
        try {
            execute = defaultClient.execute(httpPost);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return "HTTP RESULT:\t"+"request failed";
        }

//        6 gain result info
        try {
//            http status code  EG:200
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                return "执行失败:\t" + statusCode;
            }
            String ent = EntityUtils.toString(execute.getEntity(), "utf-8");
            result = ent;
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
//        result httpresponse (String)
        return result;
    }

    //    HTTP POST request
    public String doPost(String url, JSONObject post_json) {

//        1 verify url
        if (Objects.isNull(url)) {
            return "url is null";
        }

//        2 verify value
        try {
            builder = new URIBuilder(url);
            httpPost.setEntity(new StringEntity(post_json.toString(),"utf-8"));
        } catch (NullPointerException | URISyntaxException e) {
            System.out.println(e);
        }

//        3 create http request
        defaultClient = new DefaultHttpClient();
        httpPost = new HttpPost(builder.toString());

//        4 set header info
        if (source.equals("")) {
            httpPost.addHeader("content-type", content_type);
            httpPost.addHeader("authorization", token);
        } else {
            httpGet.addHeader("content-type", content_type);
            httpGet.addHeader("authorization", token);
            httpGet.addHeader("source", source);
        }

//        5 execute request
        try {
            execute = defaultClient.execute(httpPost);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return "HTTP RESULT:\t"+"request failed";
        }

//        6 gain result info
        try {
//            http status code  EG:200
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                return "执行失败:\t" + statusCode;
            }
            String ent = EntityUtils.toString(execute.getEntity(), "utf-8");
            result = ent;
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
//        result httpresponse (String)
        return result;
    }


    //    get and set methods
    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
