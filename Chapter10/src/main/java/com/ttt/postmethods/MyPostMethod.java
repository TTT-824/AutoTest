package com.ttt.postmethods;

import com.ttt.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@Api(value = "/p",description = "my all post method")
@RequestMapping("/p1")
public class MyPostMethod {

    @RequestMapping(value = "/verify/Cookiespost",method = RequestMethod.POST)
    @ApiOperation(value = "验证cookies的post方法",httpMethod = "POST")
    public String verifyCookiesPost(HttpServletResponse httpServletResponse,
                                  @RequestParam(value = "username",required = true) String username,
                                  @RequestParam(value = "password",required = true) String password){
//        判断登录信息
        if (username.equals("admin") && password.equals("admin123")){
//            add cookies
            httpServletResponse.addCookie(new Cookie("login","true"));
            return "login success";
        }
        return "请校验登录信息";
    }

    @RequestMapping(value = "/resultUser",method = RequestMethod.POST)
    @ApiOperation(value = "result user list",httpMethod = "POST")
    public String resultUser(HttpServletRequest httpServletRequest,
                             @RequestBody User user){
//        获取并验证cookies信息
        Cookie[] cookies = httpServletRequest.getCookies();

        if (Objects.isNull(cookies)){
            return "need cookies";
        }

        for (Cookie cook:cookies) {
            if (cook.getName().equals("login") && cook.getValue().equals("true")){
                User user1 = new User();
                user1.setName("admin");
                user1.setAge("22");

                return user1.toString();
            }
        }
        return "请校验参数是否正确";
    }
}
