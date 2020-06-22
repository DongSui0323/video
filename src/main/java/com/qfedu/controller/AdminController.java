package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import com.qfedu.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@Validated
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(String username, String password, HttpSession session) {
        Admin admin = adminService.findByCode(username, password);
        if(admin == null) {
            return new JsonResult(0,"用户名错误");
        }
        if (!admin.getPassword().equals(password)) {
            return new JsonResult(0,"密码错误");
        }
        session.setAttribute(StrUtils.LOGIN_USER,admin);
        JsonResult jsonResult = new JsonResult(1, null);
        return jsonResult;
    }

    @RequestMapping("/register.do")
    @ResponseBody
    public JsonResult add(String username,String password,String qpassword) {
        Admin admin = adminService.findByCode(username,password);
        if (admin != null){
            return new JsonResult(0,"用户名已存在");
        }
        if (!password.equals(qpassword)) {
            return new JsonResult(0, "密码不一致");
        }
            adminService.addOne(username, password);
            JsonResult result = new JsonResult(1, "添加成功");
            return result;
    }

    @RequestMapping("/admin.do")
    @ResponseBody
    public JsonResult getLogInfo (HttpSession session) {
        Admin u = (Admin) session.getAttribute(StrUtils.LOGIN_USER);
        Admin admin = adminService.selectByCode(u.getUsername());
        JsonResult result = new JsonResult(1,admin);
        return result;
    }

}
