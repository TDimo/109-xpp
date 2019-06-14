package com.clover.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 角色表
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
@TableName("roles")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @TableField("name")
    private String roleName;

    /**
     * 角色代号主键
     */
    @TableId("id")
    private Long roleCode;

    /**
     * 备注
     */
    @TableField("rermark")
    private String rolerermark;
    /**
     * 创建人
     */
    @TableField("create_by")
    private Long rolecreateby;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Long rolecreatetime;

    /**
     * 更新人
     */
    @TableField("update_by")
    private Long roleupdateby;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Long roleupdatetime;

    /**
     * 状态值（0：删除，1：未删除）
     */
    @TableField("del_flag")
    private Integer status;

    @Override
    protected Serializable pkVal() {
        return this.roleCode;
    }

}
