package com.example.controller;

import com.example.pojo.AnswerBean;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: AnswerController
 * Package: com.example.controller
 * Description:
 *
 * @Author xxx
 * @Create 2024/6/13 20:20
 * @Version 1.0
 */
@RequestMapping("/answer")
@Slf4j
@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    /**
     * 添加回答
     * @return
     */
    @PostMapping
    public Result add(@RequestBody AnswerBean answerBean){
        log.info("添加回答");

        answerService.add(answerBean);

        return Result.successMsg("提交成功");
    }

    /**
     * 查询所有回答
     */
    @GetMapping
    public Result findAll(@RequestParam Integer id,
                          @RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          @RequestParam String orderBy,
                          @RequestParam String orderMethod){
        PageBean answerBeanList = answerService.findAll(id, page, pageSize, orderBy, orderMethod);
        return Result.success(answerBeanList);
    }

}
