package com.ddc.server.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ddc.server.entity.DDCAdmin;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dingpengfei
 * @since 2019-05-09
 */
public interface IDDCAdminService extends IService<DDCAdmin> {


    DDCAdmin selectByName(String userNo);


    Map<String, Object> checkNameAndPasswd(JSONObject requestJson);

    List<DDCAdmin> selectAdminList(Map<String, Object> map);

    Integer selectAdminCount(Map<String, Object> map);

    Page<DDCAdmin> selectAdminPage( Map<String, Object> map);
}

