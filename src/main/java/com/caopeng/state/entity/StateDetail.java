package com.caopeng.state.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

// 统计明细表
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("state_detail") // 用来将指定的数据库表和 JavaBean 进行映射
public class StateDetail implements Serializable {
    // 主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 标题
    private String title;

    // 发布状态 0 未发布 1 发布
    private Integer status;

    // 创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date create_Time;
    // 更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date update_time;

    // 添加用户 id
    private Integer userId;
    // 添加用户名
    private String userName;

    // 参与人数
    private Integer itemNum;

    // 统计表的id
    private Integer stateid;

}
