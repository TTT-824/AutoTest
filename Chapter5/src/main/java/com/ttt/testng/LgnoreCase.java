package com.ttt.testng;

import org.testng.annotations.Test;

public class LgnoreCase {

    @Test
    public void ihnoreTest(){
        System.out.println(this.getClass().getName()+"执行");
    }
    //忽略执行
    @Test(enabled = false)
    public void ihnoreTest2(){
        System.out.println(this.getClass().getName()+"执行");
    }
}
