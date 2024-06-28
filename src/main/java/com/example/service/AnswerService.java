package com.example.service;

import com.example.pojo.AnswerBean;
import com.example.pojo.PageBean;

import java.util.List;

/**
 * ClassName: AnswerService
 * Package: com.example.service
 * Description:
 *
 * @Author xxx
 * @Create 2024/6/13 20:20
 * @Version 1.0
 */
public interface AnswerService {
    void add(AnswerBean answerBean);

    PageBean findAll(Integer id, Integer page, Integer pageSize, String orderBy, String orderMethod);

}
