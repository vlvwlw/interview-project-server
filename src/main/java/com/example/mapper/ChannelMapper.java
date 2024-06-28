package com.example.mapper;

import com.example.pojo.Channel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: ChannelMapper
 * Package: com.example.mapper
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/27 16:16
 * @Version 1.0
 */
@Mapper
public interface ChannelMapper {

    @Insert("insert into channel(create_time, update_time, name) value (now(), now(), #{name})")
    void add(Channel channel);

    @Delete("delete from channel where id = #{id}")
    void delete(Integer id);

    @Update("update channel set name = #{name} where id = #{id}")
    void update(Channel channel);

    @Select("select * from channel where id = #{id}")
    Channel findById(Integer id);

//    @Select("select * from channel order by #{orderBy} #{orderMethod} ")
    List<Channel> findAll(String orderBy, String orderMethod);


    List<Channel> findByIdList(Integer[] ids);
}
