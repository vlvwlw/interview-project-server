package com.example.controller;

import com.example.pojo.PageBean;
import com.example.pojo.Question;
import com.example.pojo.Result;
import com.example.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName: QuestionController
 * Package: com.example.controller
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/29 9:11
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * 添加问题
     */
    @PostMapping
    public Result add(@RequestBody Question question){
        log.info("添加问题，{}", question.getTitle());
        try {
            questionService.add(question);
        }catch (Exception e){
            return Result.error("添加失败，该问题已存在");
        }
        return Result.successMsg("添加成功");
    }

    /**
     * 删除问题
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除问题，{}", id);
        questionService.delete(id);
        return Result.successMsg("删除成功");
    }

    /**
     * 根据id查询问题
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根据id查询问题,{}", id);

        Question question = questionService.findById(id);
        if (question != null) {
            return Result.success(question);
        }
        return Result.error("没有找到该问题");
    }

    /**
     * 修改问题
     */
    @PutMapping
    public Result update(@RequestBody Question question){
        log.info("修改问题{}",question);

        try {
            questionService.update(question);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("修改失败");
        }
        return Result.successMsg("修改成功");
    }

    /**
     * 分页查询问题
     */
    @GetMapping
    public Result findAll(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "6") Integer pageSize,
                          String keyWord, Integer channelId,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                          @RequestParam(defaultValue = "updateTime") String orderBy,
                          @RequestParam(defaultValue = "desc") String orderMethod
                          ){
        log.info("查询所有问题");

        PageBean pageBean = questionService.findAll(page, pageSize, keyWord, channelId, begin, end, orderBy, orderMethod);
        return Result.success(pageBean);
    }

    /**
     * 恢复已删除的问题
     */
    @GetMapping("/restore")
    public Result restore(){
        log.info("恢复已删除的数据");
        try {
            questionService.restore();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("恢复失败");
        }
        return Result.successMsg("恢复成功");
    }
}
