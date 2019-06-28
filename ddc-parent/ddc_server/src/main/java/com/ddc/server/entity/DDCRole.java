package com.ddc.server.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 角色表
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
@TableName("ddc_role")
public class DDCRole extends Model<DDCRole> {

  private static final long serialVersionUID = 1L;
  /** 用户主键 */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  /** 用户名 */
  private String name;
  /** 角色等级 1 超级管理员角色 2 管理员角色 3 普通角色 */
  @TableField("role_level")
  private Integer level;

  /** 备注 */
  private String remark;
  /** 创建时间 */
  @TableField("create_time")
  private Long createTime;
  /** 创建人 */
  @TableField("create_by")
  private Long createBy;
  /** 更新人 */
  @TableField("update_by")
  private Long updateBy;
  /** 更新时间 */
  @TableField("update_time")
  private Long updateTime;

  /** 删除标志 */
  @TableField("del_flag")
  private Integer delFlag;

  @TableField(exist = false)
  private List<Long> authMsg;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }
}
