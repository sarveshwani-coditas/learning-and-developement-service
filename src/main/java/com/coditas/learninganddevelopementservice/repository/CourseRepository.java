package com.coditas.learninganddevelopementservice.repository;

import com.coditas.learninganddevelopementservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
