package com.caopeng.state.vo;

import com.baomidou.mybatisplus.annotation.*;


import com.caopeng.state.entity.StateDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
/**
 * @description: 统计报表
 * @author: xuke
 * @time: 2021/4/29 21:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@TableName("state") // 用来将指定的数据库表和 JavaBean 进行映射
public class StateVo implements java.io.Serializable {
    // 主键
    private Integer id;
    // 标题
    private String title;
    // 描述
    private String description;
    // 背景图
    private String bgImg;
    // 统计参与人数
    private Integer personNum;
    // 统计结束时间
    private String endTime;
    // 发布状态0 未发布 1 发布
    private Integer status;
    // 创建时间
    private Date create_Time;
    // 更新时间
    private Date update_time;
    // 添加用户id
    private Integer userId;
    // 添加用户名
    private String userName;
    //建立和明细的关系
    private List<StateDetail> stateDetailList;
}
