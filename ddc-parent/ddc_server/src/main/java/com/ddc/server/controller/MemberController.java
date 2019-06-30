package com.ddc.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.ddc.server.config.web.http.ResponseHelper;
import com.ddc.server.config.web.http.ResponseModel;
import com.ddc.server.entity.DDCMember;
import com.ddc.server.mapper.DDCMemberMapper;
import com.ddc.server.service.IDDCMemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/member")
@Controller
@Slf4j
public class MemberController {
    @Resource
    private IDDCMemberService memberService;
    @Resource
    private DDCMemberMapper memberMapper;

    @RequestMapping("/add")
    public String jumpAdd(Model model) throws Exception {
        return "member-add";
    }
    @RequestMapping("/show")
    public String jumpShow(Model model, @RequestParam(value = "id",required = false) String id) throws Exception {
        DDCMember member=memberMapper.selectMemberById(id);
        model.addAttribute("id",member.getId());
        model.addAttribute("username",member.getUsername());
        model.addAttribute("gender",member.getGender());
        model.addAttribute("telephone",member.getTelephone());
        model.addAttribute("postAddress",member.getPostAddress());
        model.addAttribute("address",member.getAddress());
        model.addAttribute("createTime",member.getCreateTime());
        model.addAttribute("icon",member.getIcon());
        return "member_show";
    }

    @RequestMapping("/edit")
    public String jumpEdit(Model model) throws Exception {
        return "member_edit";
    }

    @RequestMapping("/user-password-edit")
    public String jumpPwdEdit(Model model,@RequestParam(value = "id",required = false) Long id) throws Exception {
        model.addAttribute("id",id);
        return "user_password_edit";
    }

    @RequestMapping("/password_edit")
    public ModelAndView passwordEdit(Model model, @RequestParam(value = "user_id",required = false) String id,
                                     @RequestParam(value = "teacher_new_password",required = false) String teacher_new_password) throws Exception {
        memberService.updatePassword(id,teacher_new_password);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/addAction")
    @ResponseBody
    public void insertAdd(HttpServletRequest request, @RequestParam(value = "username",required = false) String username, @RequestParam(value = "password",required = false) String password,
                          @RequestParam(value = "sex",required = false) Integer sex, @RequestParam(value = "mobile",required = false) String mobile,
                          @RequestParam(value = "email",required = false) String email, @RequestParam(value = "uploadfileurl",required = false) String uploadfileurl,
                          @RequestParam(value = "city",required = false) String city,@RequestParam(value = "beizhu",required = false) String beizhu,Model model) throws Exception {
        DDCMember member = new DDCMember(username, password, sex, mobile, email,uploadfileurl,city,beizhu);
        //PasswordUtils.entryptPassword(member);
        memberMapper.insert(member);
    }

    @RequestMapping("/memberList")
    @ResponseBody
    public ResponseModel<List<DDCMember>> getMemberList(HttpServletResponse response){
        List<DDCMember> memberList=memberService.selectMemberList();
        return  ResponseHelper.buildResponseModel(memberList);
    }

    @RequestMapping("/memberSearch")
    @ResponseBody
    public ResponseModel<List<DDCMember>> getMemberSearch(HttpServletRequest request,HttpServletResponse response, @RequestParam(value = "search",required = false) String search){
        List<DDCMember> memberList=memberMapper.selectByName(search);
        return  ResponseHelper.buildResponseModel(memberList);
    }

    @RequestMapping("/deleteMember")
    @ResponseBody
    public ResponseModel<String> memberDelete(HttpServletRequest request,HttpServletResponse response, @RequestParam(value = "id",required = false) Long id){
        memberMapper.deleteById(id);
        return ResponseHelper.buildResponseModel("ok");
    }

    @RequestMapping("/memberShow")
    @ResponseBody
    public ResponseModel<DDCMember> getMemberShow(HttpServletRequest request,HttpServletResponse response, @RequestParam(value = "id",required = false) String id){
        DDCMember member=memberMapper.selectMemberById(id);
        System.out.println(id);
        return  ResponseHelper.buildResponseModel(member);
    }

    @RequestMapping("/memberEdit")
    @ResponseBody
    public ResponseModel<DDCMember> memberEdit(HttpServletRequest request,HttpServletResponse response, @RequestParam(value = "id",required = false) String id){
        DDCMember member=memberMapper.selectMemberById(id);
        System.out.println(id);
        return  ResponseHelper.buildResponseModel(member);
    }

    @RequestMapping("/updAction")
    @ResponseBody
    public boolean memberUpd(HttpServletRequest request, @RequestParam(value = "id",required = false) Long id, @RequestParam(value = "username",required = false) String username, @RequestParam(value = "sex",required = false) Integer sex,
                                              @RequestParam(value = "mobile",required = false) String mobile, @RequestParam(value = "email",required = false) String email,
                                              @RequestParam(value = "city",required = false) String city,@RequestParam(value = "beizhu",required = false) String beizhu,Model model){
        //PasswordUtils.entryptPassword(member);
        System.out.println(id);
        memberMapper.updateMember(id,username,sex,mobile,email,city,beizhu);
        return true;
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        System.out.println(subject.getPrincipal()+"退出登录！");
        return "login";
    }

    @ResponseBody
    @RequestMapping({"/demp/model/uploadAreaFile.do"})
    public String uploadAreaFile(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws Exception {
        String schoolId = request.getParameter("schoolId");//获取参数
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            File file1=new File("F:\\javaweb课程设计\\109+xpp_clone\\109-xpp\\ddc-parent\\ddc_server\\src\\main\\resources\\static\\static\\h-ui\\images\\ucnter"+file.getOriginalFilename());
            System.out.println(file1.getAbsolutePath());
            file1.createNewFile();
            file.transferTo(file1);
            //上传文件方法，这里需要改成自己项目里上传文件方法
            String filePath = "\\static\\h-ui\\images\\ucnter"+file.getOriginalFilename();//FileUploadUtil.uploadFile(file, Const.MODEL_FILE_TYPE);
            String fileName = file.getOriginalFilename();
            result.put("code", 0);
            result.put("msg", "上传成功");
            result.put("filePath", filePath);
            result.put("fileName", fileName);
            return JSONObject.toJSONString(result);
        } catch (Exception e) {
            result.put("code", -1);
            result.put("msg", "上传失败");
            result.put("filePath", "");
            return JSONObject.toJSONString(result);
        }
    }
}