package com.coditas.learninganddevelopementservice.service;

import com.coditas.learninganddevelopementservice.dto.assignment.AssignmentRequest;
import com.coditas.learninganddevelopementservice.dto.assignment.AssignmentResponse;
import com.coditas.learninganddevelopementservice.entity.Assignment;
import com.coditas.learninganddevelopementservice.entity.Course;
import com.coditas.learninganddevelopementservice.entity.Enrollment;
import com.coditas.learninganddevelopementservice.enums.EnrollmentStatus;
import com.coditas.learninganddevelopementservice.enums.Status;
import com.coditas.learninganddevelopementservice.exception.CourseNotCompleteException;
import com.coditas.learninganddevelopementservice.exception.ResourceNotFoundException;
import com.coditas.learninganddevelopementservice.mapper.AssignmentMapper;
import com.coditas.learninganddevelopementservice.repository.AssignmentRepository;
import com.coditas.learninganddevelopementservice.repository.CourseRepository;
import com.coditas.learninganddevelopementservice.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    private AssignmentRepository assignmentRepository;
    private AssignmentMapper assignmentMapper;
    private CourseRepository courseRepository;
    private EnrollmentRepository enrollmentRepository;

    private AssignmentService(AssignmentRepository assignmentRepository,EnrollmentRepository enrollmentRepository, CourseRepository courseRepository, AssignmentMapper assignmentMapper) {
        this.assignmentRepository = assignmentRepository;
        this.assignmentMapper = assignmentMapper;
        this.courseRepository = courseRepository;
        this.enrollmentRepository=enrollmentRepository;
    }

    public AssignmentResponse createAssignment(long id, AssignmentRequest assignmentRequest) {
        Assignment assignment = assignmentMapper.toEntity(assignmentRequest);

        Course course = courseRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Course Not found")
        );
        assignment.setCourse(course);
        Assignment savedAssignment = assignmentRepository.save(assignment);
        return assignmentMapper.toDTO(savedAssignment);
    }

    public AssignmentResponse getAssignment(long empId, long courseId) {

        Enrollment enrollment = enrollmentRepository.findByEmployeeIdAndCourseId(empId, courseId).orElseThrow(
                () -> new ResourceNotFoundException("Enrollment does not exist")
        );

        if(enrollment.getStatus() == EnrollmentStatus.IN_PROGRESS ||
                enrollment.getStatus() == EnrollmentStatus.NOT_STARTED)
        {
            throw new CourseNotCompleteException("First complete the course to access assignment!");
        }

        Assignment assignment = assignmentRepository.findByCourseId(courseId);
        return assignmentMapper.toDTO(assignment);

    }
}
