package com.qfedu.dao;

import com.qfedu.entity.Course;
import com.qfedu.entity.Video;
import com.qfedu.vo.VVideo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface VideoDao {
    public List<VVideo> findAll(@Param("searchInfo") String searchInfo,
                                @Param("speakerId") Integer speakerId,
                                @Param("courseId") Integer courseId);
    public void deleteOne(Video video);
    public void addOne(Video video);
    public Video findById(Integer id);
    public void updateOne(Video video);
    public void deleteSome(Integer[] ids);
}
