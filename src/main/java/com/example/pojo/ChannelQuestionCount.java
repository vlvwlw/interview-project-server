package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ClassName: ChannelQuestionCount
 * Package: com.example.pojo
 * Description:
 *
 * @Author xxx
 * @Create 2024/6/5 16:19
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChannelQuestionCount {
    private Integer channelId;
    private String channelName;
    private Integer questionCount;
}
