package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: PageBean
 * Package: com.example.pojo
 * Description:
 *  分页查询结果的封装类
 * @Author xxx
 * @Create 2024/5/19 10:37
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    private Long total;
    private List rows; // 数据列表
}
