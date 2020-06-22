package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Course;
import com.qfedu.entity.Subject;
import com.qfedu.service.CourseService;

import com.qfedu.vo.VCourseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller

public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/courseList.do")
    @ResponseBody
    public Map<String, Object> listTradeInfo(Integer page, Integer limit) {
        List<VCourseInfo> list = courseService.findAllTades(page, limit);
        //数据总条数
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap();
        map.put("code", 0);//结合layui 插件，  值必须是0
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/addCourse.do")
    @ResponseBody
    public JsonResult add(Course course){
        courseService.addCourse(course);
        return new JsonResult(1,"添加成功");
    }

    @RequestMapping("/deleteCourse.do")
    @ResponseBody
    public JsonResult delete(Integer id) {
        courseService.deleteCourse(id);
        return new JsonResult(1, "删除成功");
    }

    @RequestMapping("/subjectList.do")
    @ResponseBody
    public HashMap<Object, Object> findSubject() {
        HashMap<Object, Object> map = new HashMap<>();
        List<Subject> list = courseService.findSubjectAll();
        System.out.println(list);
        map.put("subject",list);
        return map;
    }

    @RequestMapping("/queryCourse.do")
    @ResponseBody
    public JsonResult findById(Integer id){
        Course course = courseService.findById(id);
        return new JsonResult(1,course);
    }
    @RequestMapping("/updateCourse.do")
    @ResponseBody
    public JsonResult update(Integer id,String courseTitle, String courseDesc, Integer subjectId) {

        courseService.updateCourse(id,courseTitle,courseDesc,subjectId);
        return new JsonResult(1,"修改成功");
    }

}
