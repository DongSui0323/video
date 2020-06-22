package com.qfedu.service;

import com.qfedu.entity.Speaker;
import com.qfedu.vo.VSpeakerInfo;

import java.util.List;

public interface SpeakerService {
    public List<VSpeakerInfo> findAllTades(Integer page, Integer limit);
    public List<VSpeakerInfo> findAllTades();

    public void deleteSpeaker(Integer id);

    public void addSpeaker(Speaker speaker);

    public void updateSpeaker(Integer id, String speakerName, String speakerDesc, String speakerJob, String headImgUrl);

    public Speaker findById(Integer id);
}
