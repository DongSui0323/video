package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Admin;
import com.qfedu.entity.User;
import com.qfedu.service.AdminService;
import com.qfedu.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @auth wangbo
 * @date 2020/1/2 9:26
 */
@Controller
public class UploadController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/upload2.do")
    @ResponseBody
    public JsonResult uploadFile2 (@RequestParam("file") MultipartFile upfile,
                                   String name, HttpSession session) {
        Admin admin = (Admin)session.getAttribute(StrUtils.LOGIN_USER);
        String dir = "f:/upload";
        String fileName = upfile.getOriginalFilename();
        System.out.println(fileName);
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File newFile = new File(dir, fileName);
        try {
            upfile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        adminService.updateHeadImg(admin.getId(), "/upload/"+ fileName);
        return new JsonResult(1, "上传成功");

    }
}
