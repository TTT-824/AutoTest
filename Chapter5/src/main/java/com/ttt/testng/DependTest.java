package com.ttt.testng;

import org.testng.annotations.Test;

public class DependTest {
    /*依赖测试
    * Test2需要Test先执行才能继续执行，如果Test1执行失败则不执行Test2
    * */

    @Test
    public void Test1(){
        System.out.println("Test1 run");
        //模拟异常
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"Test1"})
    public void Test2(){
        System.out.println("Test2 run");
    }
}
