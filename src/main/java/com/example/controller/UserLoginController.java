package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.UserInfo;
import com.example.service.UserInfoService;
import com.example.utils.JwtUtils;
import com.example.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * ClassName: UserLoginController
 * Package: com.example.controller
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/25 11:25
 * @Version 1.0
 */
@Slf4j
@RestController
public class UserLoginController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public Result login(@RequestBody UserInfo userInfo){
        UserInfo user = userInfoService.login(userInfo);

        if(user != null){
            log.info("{}用户登录", user.getName());

            // 生成token
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("name", user.getName());
            claims.put("username", user.getUsername());
            claims.put("customerType", user.getCustomerType());
            claims.put("selfChannelList", user.getSelfChannelList());
            String token = JwtUtils.generateJwt(claims);
            claims.put("token" ,token);

            System.out.println("-------------------------------->"+claims);
            return Result.successMsg("登录成功",claims);
        }
        return Result.error("用户名或密码错误");
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserInfo userInfo){
        log.info("{}用户注册", userInfo.getUsername());

        if(userInfo.getUsername() == null || userInfo.getUsername().length() <= 5 ||
                userInfo.getPassword() == null || userInfo.getPassword().length() <= 5 ||
                userInfo.getPassword().length() >= 16
        ){
            return Result.error("参数错误");
        }

        try {
            userInfoService.register(userInfo);
        }catch (Exception e){
            return Result.error("用户名重复");
        }
        return Result.successMsg("注册成功");
    }

    @GetMapping("/reLogin")
    public Result reLogin(){
        return Result.error("登录失效，请重新登录");
    }
}
