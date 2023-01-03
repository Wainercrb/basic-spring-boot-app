package com.crss.basicspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import com.crss.basicspringboot.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {}