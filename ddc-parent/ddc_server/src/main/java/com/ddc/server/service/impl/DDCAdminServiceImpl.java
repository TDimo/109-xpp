package com.ddc.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ddc.server.entity.DDCAdmin;
import com.ddc.server.mapper.DDCAdminMapper;
import com.ddc.server.service.IDDCAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 *
 * @author dingpengfei
 * @since 2019-05-09
 */
@Service
public class DDCAdminServiceImpl extends ServiceImpl<DDCAdminMapper, DDCAdmin>
    implements IDDCAdminService {
  @Resource private DDCAdminMapper adminMapper;

  @Override
  public DDCAdmin selectByName(String userNo) {
    return adminMapper.selectOne(new DDCAdmin(userNo));
  }

  @Override
  public Map<String, Object> checkNameAndPasswd(JSONObject requestJson) {
    // todo 检查用户名密码是否匹配 如果是反正Admin对象信息
    return null;
  }

  @Override
  public List<DDCAdmin> selectAdminList(Map<String, Object> map) {
    return null;
  }

  @Override
  public Integer selectAdminCount(Map<String, Object> map) {
    return null;
  }

  @Override
  public Page<DDCAdmin> selectAdminPage(Map<String, Object> map) {
    List<DDCAdmin> list = adminMapper.selectAdminList(map);
    Integer count = adminMapper.selectAdminCount(map);
    Page<DDCAdmin> page = new Page<>();
    page.setTotal(count);
    page.setRecords(list);
    return page;
  }
}
