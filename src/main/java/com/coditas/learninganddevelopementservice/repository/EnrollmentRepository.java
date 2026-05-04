package com.coditas.learninganddevelopementservice.repository;

import com.coditas.learninganddevelopementservice.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
