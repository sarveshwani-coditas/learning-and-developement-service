package com.coditas.learninganddevelopementservice.repository;

import com.coditas.learninganddevelopementservice.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByEmployeeId(long id);

    Optional<Enrollment> findByEmployeeIdAndCourseId(long empId, long courseId);
}
