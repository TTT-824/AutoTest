package com.ttt.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void teatherTest1(){
        System.out.println("teatherTest1教师类1");
    }

    public void teatherTest2(){
        System.out.println("teatherTest1教师类2");
    }
}
