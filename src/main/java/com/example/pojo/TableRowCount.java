package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: TableRowCount
 * Package: com.example.pojo
 * Description:
 *  获取各个表的数据数量
 * @Author xxx
 * @Create 2024/6/6 16:41
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableRowCount {
    private String tableName;
    private Integer rowCount;
}
