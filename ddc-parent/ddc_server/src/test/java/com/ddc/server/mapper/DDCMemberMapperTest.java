package com.ddc.server.mapper;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ddc.server.entity.DDCAdmin;
import com.ddc.server.entity.DDCAuth;
import com.ddc.server.entity.DDCMember;
import com.ddc.server.entity.DDCRoleAuth;
import com.ddc.server.shiro.PasswordUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


public class DDCMemberMapperTest extends BaseTest {
    @Resource
    private DDCMemberMapper memberMapper;
    @Test
    public void input(){
        DDCMember member = new DDCMember("root", 0, "13957551281", "hello@qq.com","上海","123");
        //PasswordUtils.entryptPassword(member);
        memberMapper.insert(member);
    }
}
