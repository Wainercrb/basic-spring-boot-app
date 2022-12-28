package com.crss.basicspringboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crss.basicspringboot.constants.Constants;
import com.crss.basicspringboot.model.Grade;
import com.crss.basicspringboot.repository.GradeRepository;

@Service
public class GradeService {
    
    @Autowired
    GradeRepository gradeRepository;

    public Grade getGrade(int idx) {
        return gradeRepository.getGrade(idx);
    }

    public void addGrade(Grade grade) {
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(Grade grade, int idx) {
        gradeRepository.updateGrade(idx, grade);
    }

    public List<Grade> getGrades() {
        return gradeRepository.getGrades();
    }

    public int getGradeByIndex(String id) {
        for (int i = 0; i < getGrades().size(); i++) {
            if (getGrades().get(i).getId().equals(id))
                return i;
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGradeById(String idx) {
        int index = getGradeByIndex(idx);
        return index == Constants.NOT_FOUND ? new Grade() : getGrade(index);
    }

    public void submitForm(Grade grade) {
        int index = getGradeByIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            addGrade(grade);
            return;
        }
        updateGrade(grade, index);
    }
}
