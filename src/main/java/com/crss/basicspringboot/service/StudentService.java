package com.crss.basicspringboot.service;

import java.util.List;
import com.crss.basicspringboot.entity.Student;

public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
}