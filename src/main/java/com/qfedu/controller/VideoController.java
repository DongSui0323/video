package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Course;
import com.qfedu.entity.Speaker;
import com.qfedu.entity.Subject;
import com.qfedu.entity.Video;
import com.qfedu.service.CourseService;
import com.qfedu.service.SpeakerService;
import com.qfedu.service.VideoService;
import com.qfedu.vo.VSpeakerInfo;
import com.qfedu.vo.VVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController {
    @Autowired
    VideoService videoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;
    @RequestMapping("/videoList.do")
    @ResponseBody
    public Map<String, Object> listTradeInfo(String searchInfo, Integer speakerId,
                                             Integer courseId, Integer page,
                                             Integer limit) {
        List<VVideo> list = videoService.findAllTades(searchInfo, speakerId,
                courseId, page, limit);
        //数据总条数
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap();
        map.put("code", 0);//结合layui 插件，  值必须是/**/0
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/findSAC.do")
    @ResponseBody
    public Map<String,Object> findSAC(){
        Map<String,Object> Map = new HashMap<>();
        List<Subject> coursemap = courseService.findSubjectAll();
        List<VSpeakerInfo> speakermap = speakerService.findAllTades();
        Map.put("course",coursemap);
        Map.put("speaker",speakermap);
        return Map;
    }

    @RequestMapping("/deleteVideo.do")
    @ResponseBody
    public JsonResult delete(Integer id) {
        videoService.deleteVideo(id);
        return new JsonResult(1, "删除成功");
    }

    @RequestMapping("/addVideo.do")
    @ResponseBody
    public JsonResult add(Video video){
        videoService.addVideo(video);
        return new JsonResult(1,"添加成功");
    }


    @RequestMapping("/queryVideo.do")
    @ResponseBody
    public JsonResult findById(Integer id){
        Video video = videoService.findById(id);
        return new JsonResult(1,video);
    }
    @RequestMapping("/updateVideo.do")
    @ResponseBody
    public JsonResult update(Video video) {

        videoService.updateVideo(video);
        return new JsonResult(1,"修改成功");
    }

    @RequestMapping("/deleteSomeVideo.do")
    @ResponseBody
    public JsonResult deleteSome(@RequestParam("String") Integer[] ids) {

        videoService.deleteSome(ids);
        return new JsonResult(1,"修改成功");
    }

}
