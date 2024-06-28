package com.example.mapper;

import com.example.pojo.ChannelQuestionCount;
import com.example.pojo.DailyIncreaseCountBean;
import com.example.pojo.TableRowCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: HomeMapper
 * Package: com.example.mapper
 * Description:
 *
 * @Author xxx
 * @Create 2024/6/5 16:23
 * @Version 1.0
 */
@Mapper
public interface HomeMapper {

    @Select("SELECT c.id AS channel_id, c.name AS channel_name, COUNT(q.id) AS question_count " +
            "FROM channel c LEFT JOIN " +
            "    question q ON c.id = q.channel_id " +
            "GROUP BY c.id;")
    List<ChannelQuestionCount> getChannelQuestionCount();

//    @Select("SELECT DATE_FORMAT(date(update_time), '%m-%d') AS date, COUNT(*) AS daily_increase_count FROM question " +
//            "WHERE update_time >= CURDATE() - INTERVAL #{days} DAY " +
//            "GROUP BY DATE_FORMAT(date(update_time), '%m-%d') " +
//            "ORDER BY date ASC;")


    // 查询每日增长的数量
    @Select("""
            WITH RECURSIVE date_range AS (
                SELECT CURDATE() AS date
                UNION ALL
                SELECT date - INTERVAL 1 DAY
                FROM date_range
                WHERE date > CURDATE() - INTERVAL #{days} DAY
            )
            -- 分别连接question和answers表以获取每天的数据数量
            SELECT
                dr.date,
                COALESCE(q.daily_increase_count, 0) AS daily_increase_count,
                COALESCE(a.daily_increase_answer_count, 0) AS daily_increase_answer_count
            FROM
                date_range dr
                    -- 左连接question表
                    LEFT JOIN (
                    SELECT DATE(create_time) AS date, COUNT(*) AS daily_increase_count
                    FROM question
                    WHERE status != 0
                    GROUP BY DATE(create_time)
                ) q ON dr.date = q.date
                    -- 左连接answers表
                    LEFT JOIN (
                    SELECT DATE(create_time) AS date, COUNT(*) AS daily_increase_answer_count
                    FROM answers
                    WHERE status != 0
                    GROUP BY DATE(create_time)
                ) a ON dr.date = a.date
            ORDER BY
                dr.date ASC;
            """)
    List<DailyIncreaseCountBean> getDailyIncreaseCount(Integer days);

//    @Select("""
//        -- 创建一个临时表或使用WITH语句生成过去7天的日期序列
//        WITH RECURSIVE date_range AS (
//            SELECT CURDATE() AS date
//            UNION ALL
//            SELECT date - INTERVAL 1 DAY
//            FROM date_range
//            WHERE date > CURDATE() - INTERVAL #{days} DAY
//        )
//        -- 查询并填充每天的数据数量，包括没有数据的天
//        SELECT
//            dr.date,
//            COALESCE(COUNT(q.create_time), 0) AS daily_increase_count,
//            COALESCE(COUNT(a.create_time), 0) AS daily_increase_answer_count
//        FROM
//            date_range dr
//                LEFT JOIN
//            question q ON DATE(q.create_time) = dr.date and q.status != 0
//                left join answers a on date(a.create_time) = dr.date and a.status != 0
//        GROUP BY
//            dr.date
//        ORDER BY
//            dr.date ASC;
//    """)
//    List<DailyIncreaseCountBean> getDailyIncreaseCount(Integer days);

    @Select("""
                SELECT '用户数量' AS TableName, COUNT(*) AS RowCount FROM user_info
                UNION ALL
                select '问题数量', count(*) from question where status != 0
                union  all
                SELECT '回答数量', COUNT(*) FROM answers;
            """)
    List<TableRowCount> getTableRowCount();
}
