package com.crss.basicspringboot.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.crss.basicspringboot.model.Grade;

// Solely responsible for: [CREATE, UPDATE, DELETE, LIST]
@Repository
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
