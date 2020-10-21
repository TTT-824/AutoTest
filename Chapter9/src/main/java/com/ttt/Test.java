package com.ttt;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
//
//        try {
//            BufferedReader in = new BufferedReader(new FileReader("D:\\AutoTest\\AutoTest\\Chapter9\\1111.txt"));
//            String str;
//            while ((str = in.readLine()) != null) {
//                System.out.println(str);
//            }
//            System.out.println(str);
//
//            String a = "1,2,3,4,5";
//
////            String[] split = str.split("\\r?\\n");
//            String[] split = str.split(",");
//
//            for (Object tmp:split
//                 ) {
//                System.out.println(tmp);
//            }
//
//        } catch (IOException e) {
//        }

        BufferedReader in = new BufferedReader(new FileReader("D:\\AutoTest\\AutoTest\\Chapter9\\1111.txt"));
        String str;
        for (int i = 0; i < 2; i++) {
            if ((str = in.readLine()) != null && i == 0){
                System.out.println(str);
                String[] split = str.split("，");
                System.out.println(split[0]);
            }else if ((str = in.readLine()) == null){
                break;
            }
        }
    }
}
