package com.ttt.testng.transmitdata;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TransmitOne {
    @DataProvider(name = "test")
    @Test
    public Object[][] transmitOne(){
        System.out.println("test");
        return new Object[][]{};
    }
}
