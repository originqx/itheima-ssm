package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: QX
 * @Date: 2019/9/29 12:28
 * @Version 1.0
 */
public class BCryptPasswordEncoderUtils {
    public static String passwordEncode(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
    public static void main(String[] args){
        String passwordEncode = passwordEncode("123");
        System.out.println(passwordEncode);
    }
}
