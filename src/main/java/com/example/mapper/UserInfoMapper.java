package com.example.mapper;

import com.example.pojo.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * ClassName: UserInfoMapper
 * Package: com.example.mapper
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/25 10:14
 * @Version 1.0
 */
@Mapper
public interface UserInfoMapper {
    @Insert("insert into user_info (username, name, password, email, avatar, gender, create_time, update_time)" +
            "    values (#{username}, #{name}, #{password}, #{email}, #{avatar}, #{gender}, now(), now())")
    void add(UserInfo userInfo);

    @Select("select * from user_info where is_delete != 0")
    List<UserInfo> findAll();

    @Select("select * from user_info where username = #{username} and password = #{password}")
    UserInfo getUserInfoByPassword(UserInfo userInfo);

    @Insert("insert into user_info(username, password, create_time, update_time) values(#{username}, #{password}, now(), now() )")
    void register(UserInfo userInfo);

    void updateChannelList(UserInfo userInfo);

}
