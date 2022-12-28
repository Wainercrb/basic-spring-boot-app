package com.crss.basicspringboot.repository;

import java.util.ArrayList;
import java.util.List;
import com.crss.basicspringboot.Grade;

// Solely responsible for: [CREATE, UPDATE, DELETE, LIST]
public class GradeRepository {
    private List<Grade> studentGrades = new ArrayList<>();

    public Grade getGrade(int idx) {
        return studentGrades.get(idx);
    }

    public void addGrade(Grade grade) {
        studentGrades.add(grade);
    }

    public void updateGrade(int idx, Grade grade) {
        studentGrades.set(idx, grade);
    }

    public List<Grade> getGrades() {
        return studentGrades;
    }
}
