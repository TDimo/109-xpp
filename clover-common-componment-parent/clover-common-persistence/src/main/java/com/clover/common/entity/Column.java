package com.clover.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * 栏目表
 *
 * @author gyj
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("column")
public class Column extends Model<Column> {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId("id")
    private Integer id;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 栏目名称
     */
    @TableField("clo_name")
    private String coname;
    /**
     * 内容类型
     */
    @TableField("clo_type")
    private String cotype;
    /**
     * 删除标志，1为删除
     */
    @TableField("del_flag")
    private Integer deflag;
    /**
     * 创建人
     */
    private String name;
    /**
     * 创建时间
     */
    @TableField("crea_time")
    private String retime;
    /**
     * 更新时间
     */
    @TableField("up_time")
    private String uptime;
    /**
     * 更新人
     */
    @TableField("up_name")
    private String upname;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

