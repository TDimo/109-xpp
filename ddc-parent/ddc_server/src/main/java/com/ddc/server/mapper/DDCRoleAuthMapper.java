package com.ddc.server.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.server.entity.DDCRoleAuth;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author dingpengfei
 * @since 2019-05-09
 */

public interface DDCRoleAuthMapper extends BaseMapper<DDCRoleAuth> {


    @Select("select distinct auth_id from dcc_role_auth where role_id=#{id}")
    List<Long> selectAuthList(@Param("id") Long id);
}
