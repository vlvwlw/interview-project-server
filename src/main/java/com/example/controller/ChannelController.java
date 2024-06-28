package com.example.controller;

import com.example.pojo.Channel;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.ChannelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: ChannelController
 * Package: com.example.controller
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/27 16:06
 * @Version 1.0
 */
@RequestMapping("/channel")
@Slf4j
@RestController
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    /**
     * 添加channel
     */
    @PostMapping
    public Result add(@RequestBody Channel channel){
        log.info("添加频道{}", channel.getName());

        channelService.add(channel);

        return Result.successMsg("成功添加："+ channel.getName());
    }

    /**
     * 删除channel
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除channel：{}",id);

        channelService.delete(id);

        return Result.successMsg("删除成功");
    }

    /**
     * 修改channel
     */
    @PutMapping()
    public Result update(@RequestBody Channel channel){
        log.info("修改channel:{}, id:{}", channel.getName(), channel.getId());

        try {
            channelService.update(channel);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("该名称已存在");
        }
        return Result.successMsg("修改成功");
    }

    /**
     * 根据id查询channel
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("查询channel：{}", id);

        Channel channel = channelService.findById(id);

        return Result.success(channel);
    };

    @GetMapping("/findByIds")
    public Result findByIdList(@RequestParam Integer[] ids){
        System.out.println(ids + " : " + ids.getClass());
        List<Channel> channels = channelService.findByIdList(ids);
        return Result.success(channels);
    }

    /**
     * 分页查询channel
     */
    @GetMapping
    public Result findAll(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "6") Integer pageSize,
                          @RequestParam(defaultValue = "name") String orderBy,
                          @RequestParam(defaultValue = "asc") String orderMethod){
        log.info("查询所有channel");

        PageBean pageBean = channelService.findAll(page, pageSize,orderBy, orderMethod );

        return Result.success(pageBean);
    }

}
