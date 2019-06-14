package com.clover.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 资讯表
 * </p>
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("information")
public class Information extends Model<Information> {

    private static final long serialVersionUID = 1L;
    /**
     * 用户主键id
     */
    @TableId("id")
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 简略标题
     */
    @TableField("sub_title")
    private String subtitle;
    /**
     * 分类栏目
     */
    private String column;
    /**
     * 文章类型
     */
    @TableField("title_type")
    private String titletype;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 关键字
     */
    @TableField("key_word")
    private String keyword;
    /**
     * 文章摘要
     */
    private String abstrac;
    /**
     * 内容
     */
    private String content;
    /**
     * 作者
     */
    private String author;
    /**
     * 来源
     */
    private String source;
    /**
     * 创建时间
     */
    private String retime;
    /**
     * 更新时间
     */
    private String uptime;
    /**
     * 结束时间
     */
    private String endtime;
    /**
     * 发布状态，0为草稿，1为上架，2为下架
     */
    private Integer postatus;
    /**
     * 删除标志，0为正常，1为删除
     */
    @TableField("del_flag")
    private Integer deflag;

//    @TableField(exist = false)
//    private String token;
//
//    @TableField(exist = false)
//    private String roleName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public static void main(String[] args) {
//    HMac md5Digest=new HMac();
//    md5Digest.update(Byte.parseByte(("hello"+"123")));
//    System.out.println(md5Digest.);
    }
}
