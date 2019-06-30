package com.ddc.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ddc.server.annotation.CurrentUser;
import com.ddc.server.annotation.Pass;
import com.ddc.server.entity.DDCAdmin;
import com.ddc.server.entity.DDCAuth;
import com.ddc.server.entity.DDCRole;
import com.ddc.server.entity.DDCRoleAuth;
import com.ddc.server.service.IDDCAuthService;
import com.ddc.server.service.IDDCRoleAuthService;
import com.ddc.server.service.IDDCRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
@Slf4j
public class IndexController {
    @Resource
    IDDCRoleService roleService;
    @Resource
    IDDCAuthService authService;
    @Resource
    IDDCRoleAuthService roleAuthService;
    @RequestMapping({ "/", "/index" })
    @Pass
    public ModelAndView index(@CurrentUser DDCAdmin admin) {
        ModelAndView modelAndView=new ModelAndView();
        DDCRole currentRole = roleService.selectById(admin.getRoleId());
        List<DDCRoleAuth> roleAuths=roleAuthService.selectList(new EntityWrapper<DDCRoleAuth>().
                eq("role_id",currentRole.getId()));
        Set<Long> authIds=new HashSet<>();
        if(!CollectionUtils.isEmpty(roleAuths)){
            for(DDCRoleAuth ra:roleAuths){
                authIds.add(ra.getAuthId());
            }
        }
        List<RoleController.AuthNode> list = new ArrayList<>(10);
        List<DDCAuth> topAuths =
                authService.selectList(
                        new EntityWrapper<DDCAuth>()
                                .ge("auth_level", currentRole.getLevel())
                                .eq("level", 1)
                                .eq("del_flag", 0));
        if (!CollectionUtils.isEmpty(topAuths)) {
            for (DDCAuth auth : topAuths) {
                if(!authIds.contains(auth.getId())){
                    continue;
                }
                List<DDCAuth> secondAuths =
                        authService.selectList(
                                new EntityWrapper<DDCAuth>()
                                        .ge("auth_level", currentRole.getLevel())
                                        .eq("level", 2)
                                        .eq("del_flag", 0)
                                        .eq("p_id", auth.getId()));
                List<RoleController.AuthNode> nodes2 = new ArrayList<>(10);
                if (!CollectionUtils.isEmpty(secondAuths)) {
                    for (DDCAuth secondAuth : secondAuths) {
                        if(!authIds.contains(secondAuth.getId())){
                            continue;
                        }
                        nodes2.add(new RoleController.AuthNode(secondAuth, null));
                    }
                }
                list.add(new RoleController.AuthNode(auth, nodes2));
            }
        }
        modelAndView.addObject("list",list);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/page/{view}")
    @RequiresUser
//    @Pass
    public ModelAndView page(@PathVariable String view,@CurrentUser DDCAdmin admin) {
        log.info(JSONObject.toJSONString(admin));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName(view);
        return modelAndView;
    }
}
