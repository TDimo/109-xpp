package com.clover.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wyjzq
 * @since 2019-6-14
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("manager_user")
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;
    /**
     * 用户主键
     */
    @TableId("id")
    private Long userNo;
    /**
     * 是电话号码，也是账号（登录用）
     */
    private String mobile;
    /**
     * 姓名
     */
    @TableField("name")
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleid;

    /**
     * 备注
     */
    @TableField("rermark")
    private String userrermark;
    /**
     * 创建人
     */
    @TableField("create_by")
    private Long usercreateby;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Long usercreatetime;

    /**
     * 更新人
     */
    @TableField("update_by")
    private Long userupdateby;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Long userupdatetime;

    /**
     * 状态值（0：删除，1：未删除）
     */
    @TableField("del_flag")
    private Integer status;


    @TableField(exist = false)
    private String token;

//    @TableField(exist = false)
//    private String roleName;


    @Override
    protected Serializable pkVal() {
        return this.userNo;
    }

  public static void main(String[] args) {
//    HMac md5Digest=new HMac();
//    md5Digest.update(Byte.parseByte(("hello"+"123")));
//    System.out.println(md5Digest.);
  }
}
