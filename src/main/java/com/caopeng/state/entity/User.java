package com.caopeng.state.entity;
/**
 * @author Crescent_P
 * @date 2021-05-23 18:39
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("user") // 用来将指定的数据库表和 JavaBean 进行映射
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;;

    private String userName;
    private String password;
    private String name;
}
