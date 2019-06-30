package com.ddc.server.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.server.entity.DDCMember;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DDCMemberMapper extends BaseMapper<DDCMember> {
    @Select("select * from user")
    List<DDCMember> selectAll();

    @Select("select * from user where username=#{username}")
    List<DDCMember> selectByName(@Param("username") String search);

    @Select("select * from user where id=#{id}")
    DDCMember selectMemberById(@Param("id") String id);

    @Update("update user set username=#{username},gender=#{sex},telephone=#{mobile},postAddress=#{email},city=#{city},address=#{beizhu} where id=#{id}")
    void updateMember(@Param("id") Long id, @Param("username") String username, @Param("sex") Integer sex, @Param("mobile") String mobile,
                      @Param("email") String email, @Param("city") String city, @Param("beizhu") String beizhu);

    @Update("update user set password=#{password} where id=#{id}")
    void updatePassword(@Param("id") Long id, @Param("password") String password);

    @Update("update user set statu=0 where id=#{id}")
    void updateStatuById(@Param("id") Long id);
}
