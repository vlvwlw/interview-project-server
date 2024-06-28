package com.example.controller;

import com.example.pojo.ChannelQuestionCount;
import com.example.pojo.DailyIncreaseCountBean;
import com.example.pojo.Result;
import com.example.pojo.TableRowCount;
import com.example.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: HomeController
 * Package: com.example.controller
 * Description:
 *
 * @Author xxx
 * @Create 2024/6/5 16:21
 * @Version 1.0
 */
@RequestMapping("/home")
@Slf4j
@RestController
public class HomeController {
    @Autowired
    private HomeService homeService;


    /**
     * 获取每一个频道对应问题的数量
     * @return
     */
    @GetMapping("/questionCount")
    public Result getChannelQuestionCount(){
        List<ChannelQuestionCount> channelQuestionCountList = homeService.getChannelQuestionCount();
        return Result.success(channelQuestionCountList);
    }

    /**
     * 查询？天内每天新增问题的数量
     */
    @GetMapping("/dailyIncreaseCount")
    public Result getDailyIncreaseCount(@RequestParam(defaultValue = "7") Integer days){
        List<DailyIncreaseCountBean> dailyIncreaseCountBeanList = homeService.getDailyIncreaseCount(days);

        return Result.success(dailyIncreaseCountBeanList);
    }

    /**
     * 获取各个表的数据数量
     */
    @GetMapping("/tableRowCount")
    public Result getTableRowCount(){
        List<TableRowCount> tableRowCountList = homeService.getTableRowCount();
        return Result.success(tableRowCountList);
    }
}
