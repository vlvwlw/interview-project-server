package com.example.service.impl;

import com.example.mapper.UserInfoMapper;
import com.example.pojo.UserInfo;
import com.example.service.UserInfoService;
import com.example.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: UserInfoServiceImpl
 * Package: com.example.service.impl
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/25 10:15
 * @Version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void add(UserInfo userInfo) {
        userInfoMapper.add(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.findAll();
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        // 对密码加密在判断登录
        String encrypt = MD5Util.encrypt(userInfo.getPassword());
        userInfo.setPassword(encrypt);
        return userInfoMapper.getUserInfoByPassword(userInfo);
    }

    @Override
    public void register(UserInfo userInfo) {
        // 对密码加密
        String encrypt = MD5Util.encrypt(userInfo.getPassword());
        userInfo.setPassword(encrypt);

        userInfoMapper.register(userInfo);
    }

    @Override
    public void updateChannelList(UserInfo userInfo) {
        userInfoMapper.updateChannelList(userInfo);
    }
}
