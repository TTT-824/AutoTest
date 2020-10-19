package com.ttt.testng;

import org.testng.annotations.*;

public class BasicAnnotion {

//    @Test最基本的注解，用来把方法标记为测试的一部分
//    before，after会在每个测试方法运行(时)在方法(前后)分别执行
//    @BeforeClass，@AfterClass会在每个类执行(时)在(前后)分别执行
//    @BeforeSuite，@AfterSuite会在每个类执行(之前)分别在(前后)执行

    @Test
    public void testCase1(){
        System.out.println("This is the test case!");
    }

    @Test
    public void testCase2(){
        System.out.println("This is the test case!");
    }

    @AfterMethod
    public void afterCase(){
        System.out.println("This is the after test case!");
    }

    @BeforeMethod
    public void beforeCase(){
        System.out.println("This is the before test case!");
    }

    @BeforeClass
    public void beforeTest1(){
        System.out.println("This is the BeforeClass test case!");
    }

    @AfterClass
    public void beforeTest2(){
        System.out.println("This is the AfterClass test case!");
    }

    @BeforeSuite
    public void beforeSuite1(){
        System.out.println("This is the beforeSuite test case!");
    }

    @AfterSuite
    public void afterSuite2(){
        System.out.println("This is the afterSuite test case!");
    }
}
