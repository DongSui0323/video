package com.qfedu.service;

import com.qfedu.entity.Course;
import com.qfedu.entity.Video;
import com.qfedu.vo.VVideo;

import java.lang.reflect.Array;
import java.util.List;

public interface VideoService {
    public List<VVideo> findAllTades(String searchInfo, Integer speakerId, Integer courseId, Integer page, Integer limit);
    public void deleteVideo(Integer id);
    public void addVideo(Video video);
    public Video findById(Integer id);
    public void updateVideo(Video video);
    public void deleteSome(Integer[] ids);
}
