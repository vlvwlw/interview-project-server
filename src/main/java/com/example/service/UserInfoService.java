package com.example.service;

import com.example.mapper.UserInfoMapper;
import com.example.pojo.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: UserInfoService
 * Package: com.example.service
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/25 10:12
 * @Version 1.0
 */
public interface UserInfoService {

    void add(UserInfo userInfo);

    List<UserInfo> findAll();

    UserInfo login(UserInfo userInfo);

    void register(UserInfo userInfo);

    void updateChannelList(UserInfo userInfo);
}
