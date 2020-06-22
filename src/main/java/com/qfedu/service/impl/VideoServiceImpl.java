package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.VideoDao;

import com.qfedu.entity.Video;
import com.qfedu.service.VideoService;
import com.qfedu.vo.VVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoDao videoDao;
    @Override
    public List<VVideo> findAllTades(String searchInfo, Integer speakerId,
                                     Integer courseId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<VVideo> list = videoDao.findAll(searchInfo, speakerId, courseId);
        return list;
    }

    @Override
    public void deleteVideo(Integer id) {
        Video video = new Video();
        video.setId(id);
        videoDao.deleteOne(video);
    }

    @Override
    public void addVideo(Video video) {
        videoDao.addOne(video);
    }

    @Override
    public Video findById(Integer id) {
        return videoDao.findById(id);
    }

    @Override
    public void updateVideo(Video video) {
        videoDao.updateOne(video);
    }

    @Override
    public void deleteSome(Integer[] ids) {
        videoDao.deleteSome(ids);
    }


}
