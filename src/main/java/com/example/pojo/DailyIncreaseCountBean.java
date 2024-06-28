package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ClassName: DailyIncreaseCountBean
 * Package: com.example.pojo
 * Description:
 *
 * @Author xxx
 * @Create 2024/6/5 20:24
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyIncreaseCountBean {
    private String date;
    private Integer dailyIncreaseCount;
    private Integer dailyIncreaseAnswerCount;
}
