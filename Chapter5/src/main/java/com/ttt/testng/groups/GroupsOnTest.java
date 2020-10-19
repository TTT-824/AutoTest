package com.ttt.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnTest {

    @Test(groups = "server")
    public void testS1(){
        System.out.println(this.getClass().getName());
    }

    @Test(groups = "server")
    public void testS2(){
        System.out.println(this.getClass().getName());
    }

    @Test(groups = "client")
    public void testS3(){
        System.out.println(this.getClass().getName());
    }

    @Test(groups = "client")
    public void testS4(){
        System.out.println(this.getClass().getName());
    }

    @BeforeGroups(groups = "server")
    public void testS5(){
        System.out.println(this.getClass().getName() + "testS5");
    }

    @AfterGroups(groups = "server")
    public void testS6(){
        System.out.println(this.getClass().getName() + "testS6");
    }
}
