package com.crss.basicspringboot.service;

import java.util.List;

import com.crss.basicspringboot.entity.Course;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
}