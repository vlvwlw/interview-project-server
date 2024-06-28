package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName: Question
 * Package: com.example.pojo
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/29 9:07
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {
    private Integer id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String title;
    private Integer likeCount;
    private Integer readCount;
    private Integer collectionCount;
    private Integer channelId;
    private Integer creatorId;
    private String content;
    private Byte status;
    private String tags;
    private Channel channel;
    private UserInfo userInfo;
}
