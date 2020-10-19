package com.ttt.testng;

import org.testng.annotations.Test;

public class AnomalyTest {
    /*
    * 什么时候需要用到异常测试？
    * 在需要得到程序指定的异常结果的时候
    * 比如我们传入了一个不合法的异常，需要得到一个指定的异常结果
    */

    @Test(expectedExceptions = RuntimeException.class)
    public void resultFaild(){
        System.out.println("failed");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void resultSuccess(){
        System.out.println("success");
        throw new RuntimeException();
    }
}
