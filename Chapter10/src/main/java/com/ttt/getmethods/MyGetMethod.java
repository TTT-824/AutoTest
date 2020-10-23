package com.ttt.getmethods;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "我的全部GET方法") //swagger注解
public class MyGetMethod {

//    返回携带cookies的请求
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "返回携带cookies的请求",httpMethod = "GET")   //swagger注解
    public String getCookies(HttpServletResponse httpServletResponse) {
//        add cookies
        Cookie cookie = new Cookie("login", "true");
        httpServletResponse.addCookie(cookie);
        return "success";
    }

//    需要携带cookies的请求
    @RequestMapping(value = "/verifyCookies", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带cookies的请求",httpMethod = "GET")   //swagger注解
    public String verifyCookies(HttpServletRequest httpServletRequest) {
//        verify cookies
        Cookie[] cookies = httpServletRequest.getCookies();
//        if is empty
        if (Objects.isNull(cookies)) {
            return "failed:need cookies";
        }else {
            for (Cookie tmp : cookies) {
                if (tmp.getName().equals("login")
                        && tmp.getValue().equals("true")) {
                    System.out.println("------------------");
                    System.out.println(tmp.getName()+"\t"+tmp.getValue());
                    return "cookies if success1";
                }
            }
        }
        return "cookies if success";
    }

//    需要携带参数才能访问的GET请求
//    第一种：http://localhost:8080/getmethod/?param1=1&param2=2
    @RequestMapping(value = "/needparammetho/one",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的GET请求第一种",httpMethod = "GET")   //swagger注解
    public Map<String,Integer> needParamMethodOne(@RequestParam Integer start,
                                               @RequestParam Integer end){
        HashMap<String, Integer> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("shoe",1);
        objectObjectHashMap.put("clothing",2);
        objectObjectHashMap.put("pants",3);
        objectObjectHashMap.put("method",1);
        return objectObjectHashMap;
    }

//    需要携带参数才能访问的GET请求
//    第二种：http://localhost:8080/getmethod/start1/end2
    @RequestMapping(value = "/needparammethod/two/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的GET请求第二种",httpMethod = "GET")   //swagger注解
    public Map<String,Integer> needParamMethodTwo(@PathVariable Integer start,
                                               @PathVariable Integer end){
        HashMap<String, Integer> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("shoe",1);
        objectObjectHashMap.put("clothing",2);
        objectObjectHashMap.put("pants",3);
        objectObjectHashMap.put("method",2);
        return objectObjectHashMap;
    }
}
