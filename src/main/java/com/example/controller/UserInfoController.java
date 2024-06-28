package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.UserInfo;
import com.example.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: UserInfoController
 * Package: com.example.controller
 * Description:
 *  用户信息表controller类
 * @Author xxx
 * @Create 2024/5/25 10:10
 * @Version 1.0
 */
@RequestMapping("/userinfo")
@Slf4j
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 添加用户
     */
    @PostMapping
    public Result add(@RequestBody UserInfo userInfo){
        log.info("新增用户{}", userInfo.getName());
        userInfoService.add(userInfo);
        return Result.success();
    }

    /**
     * 查询所有用户
     */
    @GetMapping
    public Result findAll(){
        log.info("查询所有用户");
        List<UserInfo> userInfoList = userInfoService.findAll();
        return Result.success(userInfoList);
    }

    /**
     * 更新用户信息
     */
    @PutMapping
    public Result updateChannelList(@RequestBody UserInfo userInfo){
        log.info("修改用户{}", userInfo);
        userInfoService.updateChannelList(userInfo);
        return Result.successMsg("修改成功");
    }
}
