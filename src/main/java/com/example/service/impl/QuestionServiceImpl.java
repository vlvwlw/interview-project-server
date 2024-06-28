package com.example.service.impl;

import com.example.mapper.QuestionMapper;
import com.example.pojo.PageBean;
import com.example.pojo.Question;
import com.example.service.QuestionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * ClassName: QuestionServiceImpl
 * Package: com.example.service.impl
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/29 9:13
 * @Version 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void add(Question question) {
        questionMapper.add(question);
    }

    @Override
    public void delete(Integer id) {
        questionMapper.delete(id);
    }

    @Override
    public Question findById(Integer id) {
        return questionMapper.findById(id);
    }

    @Override
    public void update(Question question) {
        questionMapper.update(question);
    }

    @Override
    public PageBean findAll(Integer page, Integer pageSize, String keyWord, Integer channelId, LocalDate begin, LocalDate end, String orderBy, String orderMethod) {
        // 设置分页参数
        PageHelper.startPage(page,  pageSize);

        // 执行查询
        List<Question> questionList = questionMapper.findAll(keyWord, channelId, begin, end, orderBy, orderMethod);
        Page<Question> p = (Page<Question>) questionList;

        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void restore() {
        questionMapper.restore();
    }
}
