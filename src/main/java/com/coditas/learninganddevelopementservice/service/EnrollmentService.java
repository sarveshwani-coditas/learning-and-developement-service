package com.coditas.learninganddevelopementservice.service;

import com.coditas.learninganddevelopementservice.dto.enrollment.EnrollmentRequest;
import com.coditas.learninganddevelopementservice.dto.enrollment.EnrollmentResponse;
import com.coditas.learninganddevelopementservice.entity.Course;
import com.coditas.learninganddevelopementservice.entity.Employee;
import com.coditas.learninganddevelopementservice.entity.Enrollment;
import com.coditas.learninganddevelopementservice.mapper.EnrollmentMapper;
import com.coditas.learninganddevelopementservice.repository.CourseRepository;
import com.coditas.learninganddevelopementservice.repository.EmployeeRepository;
import com.coditas.learninganddevelopementservice.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;
    private EmployeeRepository employeeRepository;
    private CourseRepository courseRepository;
    private EnrollmentMapper enrollmentMapper;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, EnrollmentMapper enrollmentMapper, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
        this.enrollmentMapper = enrollmentMapper;
    }

    public EnrollmentResponse enroll(EnrollmentRequest enrollmentRequest) {
        Employee employee = employeeRepository.findById(enrollmentRequest.getEmployeeId()).orElseThrow(
                () -> new RuntimeException("Not found")
        );

        Course course = courseRepository.findById(enrollmentRequest.getCourseId()).orElseThrow(
                () -> new RuntimeException("Not found")
        );

        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentRequest);
        enrollment.setCourse(course);
        enrollment.setEmployee(employee);
        enrollment.setDeadline(LocalDate.now());
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);

        return enrollmentMapper.toDTO(savedEnrollment);
    }


    public List<EnrollmentResponse> getAllEnrollments() {

        List<Enrollment> enrollments = enrollmentRepository.findAll();

        return enrollmentMapper.toDTOList(enrollments);
    }
}
