package com.example.service;

import com.example.pojo.PageBean;
import com.example.pojo.Question;

import java.time.LocalDate;

/**
 * ClassName: QuestionService
 * Package: com.example.service
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/29 9:13
 * @Version 1.0
 */
public interface QuestionService {
    void add(Question question);

    void delete(Integer id);

    Question findById(Integer id);

    void update(Question question);

    PageBean findAll(Integer page, Integer pageSize, String keyWord, Integer channelId, LocalDate begin, LocalDate end, String orderBy, String orderMethod);

    void restore();
}
