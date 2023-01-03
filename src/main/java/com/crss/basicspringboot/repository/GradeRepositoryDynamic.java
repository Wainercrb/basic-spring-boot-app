package com.crss.basicspringboot.repository;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.crss.basicspringboot.entity.GradeDynamic;

// Solely responsible for: [CREATE, UPDATE, DELETE, LIST]
public interface GradeRepositoryDynamic extends CrudRepository<GradeDynamic, Long> {
    Optional<GradeDynamic> findByStudentIdAndCourseId(Long studentId, Long courseId);

    List<GradeDynamic> findByStudentId(Long studentId);

    List<GradeDynamic> findByCourseId(Long courseId);

    @Transactional
    void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
}
