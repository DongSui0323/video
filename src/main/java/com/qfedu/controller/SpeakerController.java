package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Speaker;
import com.qfedu.service.SpeakerService;
import com.qfedu.vo.VSpeakerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;
    @RequestMapping("/speakerList.do")
    @ResponseBody
    public Map<String, Object> listTradeInfo(Integer page, Integer limit) {

        List<VSpeakerInfo> list = speakerService.findAllTades(page, limit);
        //数据总条数
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap();
        map.put("code", 0);//结合layui 插件，  值必须是0
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/deleteSpeaker.do")
    @ResponseBody
    public JsonResult delete(Integer id) {
        speakerService.deleteSpeaker(id);

        return new JsonResult(1, "删除成功");
    }


    @RequestMapping("/querySpeaker.do")
    @ResponseBody
    public JsonResult findById(Integer id){
        Speaker speaker = speakerService.findById(id);
        return new JsonResult(1,speaker);
    }
    @RequestMapping("/updateSpeaker.do")
    @ResponseBody
    public JsonResult update(Integer id,String speakerName,String speakerDesc,String speakerJob,String headImgUrl) {

        speakerService.updateSpeaker(id,speakerName,speakerDesc,speakerJob,headImgUrl);
        return new JsonResult(1,"修改成功");
    }



    @RequestMapping("/addSpeaker.do")
    @ResponseBody
    public JsonResult add(Speaker speaker) {
        speakerService.addSpeaker(speaker);
        return new JsonResult(1,"添加成功");
    }



}
