package com.bhzj.cloud.test;

import java.util.UUID;

public class Test {
    public static void main(String[] args) throws Exception {
        for(int i=0;i<20;i++){
            String initPassword = UUID.randomUUID().toString().replaceAll("-","");
            System.out.println(initPassword + "----" + initPassword.length());
        }
    }
}
