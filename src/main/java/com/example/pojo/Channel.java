package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ClassName: Channel
 * Package: com.example.pojo
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/27 16:03
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Channel {
    private Integer id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String name;
}
