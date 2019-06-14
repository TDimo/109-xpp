package com.clover.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 访问记录表
 * </p>
 *
 * @author Dimo
 * @since 2019-06-14
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("user")
public class BrowseRecord extends Model<BrowseRecord> {

    private static final long serialVersionUID = 1L;
    /**
     * 访问记录表的主键为browse_id
     */
    @TableId("browse_id")
    private long browseId;

    /**
     * 是用户名，也是账号的名称
     */
    @TableField("user_id")
    private long userId;

    /**
     * 访问的ip地址
     */
    private String ip;

    /**
     * 访问时间
     */
    @TableField("visit_time")
    private String visitTime;

    /**
     * 是否为会员（1为是，0为否）
     */
    @TableField("is_member")
    private int isMenber;

    /**
     * 访问咨询id
     */
    @TableField("info_id")
    private long infoId;

    /**
     * 访问咨询标题
     */
    @TableField("info_title")
    private String infoTitle;

    @Override
    protected Serializable pkVal() {
        return this.browseId;
    }

    public static void main(String[] args) {
//    HMac md5Digest=new HMac();
//    md5Digest.update(Byte.parseByte(("hello"+"123")));
//    System.out.println(md5Digest.);
    }
}
