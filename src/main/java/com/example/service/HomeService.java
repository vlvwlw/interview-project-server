package com.example.service;

import com.example.pojo.ChannelQuestionCount;
import com.example.pojo.DailyIncreaseCountBean;
import com.example.pojo.TableRowCount;

import java.util.List;

/**
 * ClassName: HomeService
 * Package: com.example.service
 * Description:
 *
 * @Author xxx
 * @Create 2024/6/5 16:23
 * @Version 1.0
 */
public interface HomeService {
    List<ChannelQuestionCount> getChannelQuestionCount();

    List<DailyIncreaseCountBean> getDailyIncreaseCount(Integer days);

    List<TableRowCount> getTableRowCount();

}
