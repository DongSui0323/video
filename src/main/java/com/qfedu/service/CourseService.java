package com.qfedu.service;

import com.qfedu.entity.Course;
import com.qfedu.entity.Speaker;
import com.qfedu.entity.Subject;
import com.qfedu.vo.VCourseInfo;
import com.qfedu.vo.VSpeakerInfo;

import java.util.List;

public interface CourseService {
    public List<VCourseInfo> findAllTades(Integer page, Integer limit);
    public void deleteCourse(Integer id);
    public List<Subject> findSubjectAll();
    public void updateCourse(Integer id, String courseTitle, String courseDesc, Integer subjectId);
    public void addCourse(Course course);
    public Course findById(Integer id);
}
