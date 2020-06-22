package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.SpeakerDao;
import com.qfedu.entity.Speaker;
import com.qfedu.service.SpeakerService;
import com.qfedu.vo.VSpeakerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerDao speakerDao;
    @Override
    public List<VSpeakerInfo> findAllTades(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<VSpeakerInfo> list= speakerDao.findAll();
        return list;
    }

    @Override
    public List<VSpeakerInfo> findAllTades() {
        List<VSpeakerInfo> list= speakerDao.findAll();
        return list;
    }

    @Override
    public void deleteSpeaker(Integer id) {
        Speaker speaker = new Speaker();
        speaker.setId(id);
        speakerDao.deleteOne(speaker);

    }

    @Override
    public void addSpeaker(Speaker speaker) {
        speakerDao.add(speaker);
    }

    @Override
    public void updateSpeaker(Integer id, String speakerName, String speakerDesc, String speakerJob, String headImgUrl) {
        Speaker speaker = new Speaker();
        speaker.setId(id);
        speaker.setSpeakerName(speakerName);
        speaker.setSpeakerDesc(speakerDesc);
        speaker.setSpeakerJob(speakerJob);
        speaker.setHeadImgUrl(headImgUrl);
        speakerDao.updateOne(speaker);
    }

    @Override
    public Speaker findById(Integer id) {
        return speakerDao.findById(id);
    }
}
