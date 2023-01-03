package com.crss.basicspringboot.service;

import java.util.List;
import com.crss.basicspringboot.entity.GradeDynamic;

public interface GradeServiceDynamic {
    GradeDynamic getGrade(Long studentId, Long courseId);
    GradeDynamic saveGrade(GradeDynamic grade, Long studentId, Long courseId);
    GradeDynamic updateGrade(String score, Long studentId, Long courseId);
    void deleteGrade(Long studentId, Long courseId);
    List<GradeDynamic> getStudentGrades(Long studentId);
    List<GradeDynamic> getCourseGrades(Long courseId);
    List<GradeDynamic> getAllGrades();
}
