package com.example.service;

import com.example.pojo.Channel;
import com.example.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ChannelService
 * Package: com.example.service
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/27 16:09
 * @Version 1.0
 */

public interface ChannelService {
    void add(Channel channel);

    void delete(Integer id);

    void update(Channel channel);

    Channel findById(Integer id);

    PageBean findAll(Integer page, Integer pageSize, String orderBy, String orderMethod);

    List<Channel> findByIdList(Integer[] ids);
}
