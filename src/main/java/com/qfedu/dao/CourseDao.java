package com.qfedu.dao;

import com.qfedu.entity.Course;
import com.qfedu.entity.Speaker;
import com.qfedu.entity.Subject;
import com.qfedu.vo.VCourseInfo;

import java.util.List;

public interface CourseDao {
    public List<VCourseInfo> findAll();
    public void deleteOne(Course course);
    public void updateOne(Course course);
    public List<Subject> findSubject();
    public void addOne(Course course);
    public Course findById(Integer id);
}
