package com.example.mapper;

import com.example.pojo.AnswerBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: AnswerMapper
 * Package: com.example.mapper
 * Description:
 *
 * @Author xxx
 * @Create 2024/6/13 20:21
 * @Version 1.0
 */
@Mapper
public interface AnswerMapper {

    @Insert("insert into answers(create_time, update_time, answer, question_id, creator_id) " +
            "values (now(), now(), #{answer},#{questionId}, #{creatorId})")
    void add(AnswerBean answerBean);


    List<AnswerBean> findAll(Integer id, String orderBy, String orderMethod);

}
