package com.example;

import com.example.utils.JwtUtils;
import com.example.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class InterviewProjectApplicationTests {

    @Test
    void contextLoads() {
//        System.out.println("hello world");
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("hello", "world");
        String s = JwtUtils.generateJwt(claims);
        System.out.println(s);
    }

    @Test
    public void testMD5(){
        String encrypt = MD5Util.encrypt("123123");
        System.out.println(encrypt);
    }

}
