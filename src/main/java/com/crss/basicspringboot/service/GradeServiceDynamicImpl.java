package com.crss.basicspringboot.service;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.crss.basicspringboot.entity.Course;
import com.crss.basicspringboot.entity.GradeDynamic;
import com.crss.basicspringboot.entity.Student;
import com.crss.basicspringboot.exception.GradeNotFoundException;
import com.crss.basicspringboot.repository.CourseRepository;
import com.crss.basicspringboot.repository.GradeRepositoryDynamic;
import com.crss.basicspringboot.repository.StudentRepository;

@AllArgsConstructor
@Service
public class GradeServiceDynamicImpl implements GradeServiceDynamic {

    GradeRepositoryDynamic gradeRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;

    @Override
    public GradeDynamic getGrade(Long studentId, Long courseId) {
        Optional<GradeDynamic> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        return unwrapGrade(grade, studentId, courseId);
    }

    @Override
    public GradeDynamic saveGrade(GradeDynamic grade, Long studentId, Long courseId) {
        Student student = StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId);
        Course course = CourseServiceImpl.unwrapCourse(courseRepository.findById(courseId), courseId);
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    @Override
    public GradeDynamic updateGrade(String score, Long studentId, Long courseId) {
        Optional<GradeDynamic> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        GradeDynamic unwrappedGrade = unwrapGrade(grade, studentId, courseId);
        unwrappedGrade.setScore(score);
        return gradeRepository.save(unwrappedGrade);
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<GradeDynamic> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<GradeDynamic> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<GradeDynamic> getAllGrades() {
        return (List<GradeDynamic>) gradeRepository.findAll();
    }

    static GradeDynamic unwrapGrade(Optional<GradeDynamic> entity, Long studentId, Long courseId) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new GradeNotFoundException(studentId, courseId);
    }
}
