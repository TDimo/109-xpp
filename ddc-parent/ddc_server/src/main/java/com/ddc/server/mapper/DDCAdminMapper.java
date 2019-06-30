package com.ddc.server.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.server.entity.DDCAdmin;

import java.util.List;
import java.util.Map;

/**
 * Mapper 接口
 *
 * @author dingpengfei
 * @since 2019-05-09
 */
public interface DDCAdminMapper extends BaseMapper<DDCAdmin> {


    List<DDCAdmin> selectAdminList(Map<String, Object> map);

    Integer selectAdminCount(Map<String, Object> map);
}
