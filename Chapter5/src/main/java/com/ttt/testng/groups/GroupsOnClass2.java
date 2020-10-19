package com.ttt.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {

    public void stuTest1(){
        System.out.println("stuTest2学生类1");
    }

    public void stuTest2(){
        System.out.println("stuTest2学生类2");
    }
}
