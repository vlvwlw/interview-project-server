package com.example.service.impl;

import com.example.mapper.ChannelMapper;
import com.example.pojo.Channel;
import com.example.pojo.PageBean;
import com.example.service.ChannelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ChannelServiceImpl
 * Package: com.example.service.impl
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/27 16:09
 * @Version 1.0
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public void add(Channel channel) {
        channelMapper.add(channel);
    }

    @Override
    public void delete(Integer id) {
        channelMapper.delete(id);
    }

    @Override
    public void update(Channel channel) {
        channelMapper.update(channel);
    }

    @Override
    public Channel findById(Integer id) {
        return channelMapper.findById(id);
    }

    @Override
    public PageBean findAll(Integer page, Integer pageSize, String orderBy, String orderMethod) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);

        // 执行查询
        List<Channel> channelList = channelMapper.findAll(orderBy, orderMethod );
        Page<Channel> p = (Page<Channel>) channelList;

        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
//        return channelMapper.findAll(page, pageSize);
    }

    @Override
    public List<Channel> findByIdList(Integer[] ids) {
        return channelMapper.findByIdList(ids);
    }
}
