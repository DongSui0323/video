package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CourseDao;
import com.qfedu.dao.SpeakerDao;
import com.qfedu.entity.Course;
import com.qfedu.entity.Speaker;
import com.qfedu.entity.Subject;
import com.qfedu.service.CourseService;
import com.qfedu.vo.VCourseInfo;
import com.qfedu.vo.VSpeakerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<VCourseInfo> findAllTades(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<VCourseInfo> list= courseDao.findAll();
        return list;
    }

    @Override
    public void deleteCourse(Integer id) {
        Course course = new Course();
        course.setId(id);
        courseDao.deleteOne(course);
    }

    @Override
    public List<Subject> findSubjectAll() {
        List<Subject> list = courseDao.findSubject();
        return list;
    }

    @Override
    public void updateCourse(Integer id, String courseTitle, String courseDesc, Integer subjectId) {
        Course course = new Course();
        course.setId(id);
        course.setCourseTitle(courseTitle);
        course.setCourseDesc(courseDesc);
        course.setSubjectId(subjectId);
        courseDao.updateOne(course);
    }

    @Override
    public void addCourse(Course course){
        courseDao.addOne(course);
    }

    @Override
    public Course findById(Integer id) {
        return courseDao.findById(id);
    }
}
