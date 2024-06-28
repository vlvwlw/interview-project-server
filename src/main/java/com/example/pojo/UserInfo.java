package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ClassName: UserInfo
 * Package: com.example.pojo
 * Description:
 *
 * @Author xxx
 * @Create 2024/5/25 10:05
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer id;
    private String username;
    private String name;
    private String password;
    private String email;
    private String avatar;
    private Short gender;
    private Integer customerType;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Short isDelete;
    private String selfChannelList;

}
