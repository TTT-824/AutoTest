package com.ttt.getmethods;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class MyGetMethod {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse httpServletResponse) {
//        add cookies
        Cookie cookie = new Cookie("login", "true");
        httpServletResponse.addCookie(cookie);
        return "success";
    }

    @RequestMapping(value = "/verifyCookies", method = RequestMethod.GET)
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
}
