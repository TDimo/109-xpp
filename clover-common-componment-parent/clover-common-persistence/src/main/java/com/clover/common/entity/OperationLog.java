﻿package com.clover.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author dingpengfei
 * @since 2019-05-09
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("ddc_system_log")
public class OperationLog extends Model<OperationLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer operationLogId;
    /**
     * 日志描述
     */
    @TableField("content")
    private String logDescription;
    /**
     * 方法参数
     */
    @TableField("action_args")
    private String actionArgs;
    /**
     * 用户主键
     */
    @TableField("user_no")
    private String userNo;
    /**
     * 类名称
     */
    @TableField("class_name")
    private String className;
    /**
     * 方法名称
     */
    @TableField("method_name")
    private String methodName;
    private String ip;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Long createTime;
    /**
     * 是否成功 1:成功 2异常
     */
    private Integer succeed;
    /**
     * 异常堆栈信息
     */
    private String message;

    /**
     * 模块名称
     */
    @TableField("model_name")
    private String modelName;

    /**
     * 操作
     */
    private String action;

    @Override
    protected Serializable pkVal() {
        return this.operationLogId;
    }

}
