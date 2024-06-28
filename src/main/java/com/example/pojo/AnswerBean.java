package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName: AnswerBean
 * Package: com.example.pojo
 * Description:
 *
 * @Author xxx
 * @Create 2024/6/13 20:17
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class AnswerBean {
    private Integer id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String answer;
    private Integer questionId;
    private Integer likeCount;
    private Integer collectionCount;
    private Integer readCount;
    private Integer status;
    private Integer creatorId;
}
