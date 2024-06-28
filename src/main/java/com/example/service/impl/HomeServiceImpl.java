package com.example.service.impl;

import com.example.mapper.HomeMapper;
import com.example.pojo.ChannelQuestionCount;
import com.example.pojo.DailyIncreaseCountBean;
import com.example.pojo.TableRowCount;
import com.example.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: HomeServieImpl
 * Package: com.example.service.impl
 * Description:
 *
 * @Author xxx
 * @Create 2024/6/5 16:23
 * @Version 1.0
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;

    @Override
    public List<ChannelQuestionCount> getChannelQuestionCount() {
        return homeMapper.getChannelQuestionCount();
    }

    @Override
    public List<DailyIncreaseCountBean> getDailyIncreaseCount(Integer days) {
        return homeMapper.getDailyIncreaseCount(days - 1);
    }

    @Override
    public List<TableRowCount> getTableRowCount() {
        return homeMapper.getTableRowCount();
    }
}
