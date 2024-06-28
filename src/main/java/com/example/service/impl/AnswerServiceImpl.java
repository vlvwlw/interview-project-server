package com.example.service.impl;

import com.example.mapper.AnswerMapper;
import com.example.pojo.AnswerBean;
import com.example.pojo.PageBean;
import com.example.service.AnswerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: AnswerServiceImpl
 * Package: com.example.service.impl
 * Description:
 *
 * @Author xxx
 * @Create 2024/6/13 20:21
 * @Version 1.0
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public void add(AnswerBean answerBean) {
        answerMapper.add(answerBean);
    }

    @Override
    public PageBean findAll(Integer id, Integer page, Integer pageSize,String orderBy, String orderMethod) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);

        // 执行查询
        List<AnswerBean> answerBeanList = answerMapper.findAll(id, orderBy, orderMethod);
        Page<AnswerBean> p = (Page<AnswerBean>) answerBeanList;

        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;

//        return answerMapper.findAll(id, page, pageSize, orderBy, orderMethod);
    }
}
