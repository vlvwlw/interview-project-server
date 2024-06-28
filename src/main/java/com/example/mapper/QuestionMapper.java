package com.example.mapper;

import com.example.pojo.Question;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * ClassName: QuestionMapper
 * Package: com.example.mapper
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/29 9:14
 * @Version 1.0
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title, channel_id, creator_id, content, tags) " +
            "values (#{title}, #{channelId}, #{creatorId}, #{content}, #{tags})")
    void add(Question question);

    @Update("update question set status = 0 where id = #{id}")
    void delete(Integer id);

    @Select("select * from question where id  = #{id}")
    Question findById(Integer id);

//    @Update("update question set title = #{title} where id = #{id}")
    void update(Question question);

//    @Select("select * from question where status != 0")
//    @Select("SELECT q.*, c.name as channelName, u.username as username " +
//            "FROM question q " +
//            "    INNER JOIN channel c ON c.id = q.channel_id " +
//            "    inner join user_info u on q.creator_id = u.id")
//    @Results({
//            @Result(property = "username", column = "u.username", many = @Many(select = "com.example.pojo.UserInfo.getUsername"))
//    })
    List<Question> findAll(String keyWord, Integer channelId, LocalDate begin, LocalDate end, String orderBy, String orderMethod);

    @Update("update question set status = 1 where status = 0")
    void restore();
}
