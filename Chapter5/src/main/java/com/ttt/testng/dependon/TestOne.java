package com.ttt.testng.dependon;

import org.testng.annotations.Test;

@Test(groups = "tem1")
public class TestOne {
    @Test
    public void testOne(){
        System.out.println("testOne");
    }
}
