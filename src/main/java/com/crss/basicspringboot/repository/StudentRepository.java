package com.crss.basicspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import com.crss.basicspringboot.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {}
