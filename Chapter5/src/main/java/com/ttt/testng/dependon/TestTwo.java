package com.ttt.testng.dependon;

import org.testng.annotations.Test;

public class TestTwo {
    @Test(dependsOnGroups = "tem1")
    public void testTwo(){
        System.out.println("testTwo");
    }
}
