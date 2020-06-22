package com.qfedu.dao;

import com.qfedu.entity.Speaker;
import com.qfedu.vo.VSpeakerInfo;

import java.util.List;

public interface SpeakerDao {
    public List<VSpeakerInfo> findAll();
    public void deleteOne(Speaker speaker);
    public void updateOne(Speaker speaker);
    public void add(Speaker speaker);
    public Speaker findById(Integer id);
}
