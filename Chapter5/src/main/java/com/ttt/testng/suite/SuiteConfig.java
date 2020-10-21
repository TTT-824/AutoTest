package com.ttt.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("你要登录吗？去吧！我给你准备好了。");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("你登陆完成了，真棒！");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("再检查一次");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("再检查一次,完毕");
    }
}
