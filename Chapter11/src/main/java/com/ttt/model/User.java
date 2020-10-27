package com.ttt.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@Data
public class User {
    private Integer id;
    private String name;
    private String phone;
    private Integer sex;

    @Override
    public String toString() {
        return "{" +
                "\"id\""+":"+ id +","+
                "\"name\""+":"+ "\""+name +"\""+","+
                "\"phone\""+":"+ "\""+name +"\""+","+
                "\"sex\""+":"+ sex+
                '}';
    }
}
