package com.ttt.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestDemo {
    //断言 false
    @Test
    public void test1(){
        System.out.println("-------");
        Assert.assertEquals(1,2);
    }
    //断言true
    @Test
    public void test2(){
        System.out.println("-------");
        Assert.assertEquals(1,1);
    }
    //日志记录
    @Test
    public void test3(){
        Reporter.log("rizhijilu");
        //模拟异常
        throw new RuntimeException("模拟异常");
    }
}
