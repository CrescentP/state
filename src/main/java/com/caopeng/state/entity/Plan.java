package com.caopeng.state.entity;/**
 * @author Crescent_P
 * @date 2021-05-24 10:39
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Crescent_P
 * @date 2021-05-24 10:39
 *  计划学习内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("plan") // 用来将指定的数据库表和 JavaBean 进行映射
public class Plan {
    // 主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 标题
    private String name;
}
