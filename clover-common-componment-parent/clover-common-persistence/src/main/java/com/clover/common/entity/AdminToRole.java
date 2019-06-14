package com.clover.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 用户角色关系表
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
@TableName("sdk_back_admin_to_role")
public class AdminToRole extends Model<AdminToRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "user_to_role_id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色ID
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 权限ID
     */
    @TableField("auth_id")
    private  Integer authId;
    /**
     * 用户编号
     */
    @TableField(exist = false)
    private String userNo;
    /**
     * 角色代号
     */
    @TableField(exist = false)
    private String roleCode;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
