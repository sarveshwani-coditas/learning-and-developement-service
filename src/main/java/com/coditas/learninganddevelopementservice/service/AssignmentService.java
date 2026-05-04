package com.coditas.learninganddevelopementservice.service;

import com.coditas.learninganddevelopementservice.dto.assignment.AssignmentRequest;
import com.coditas.learninganddevelopementservice.dto.assignment.AssignmentResponse;
import com.coditas.learninganddevelopementservice.entity.Assignment;
import com.coditas.learninganddevelopementservice.entity.Course;
import com.coditas.learninganddevelopementservice.mapper.AssignmentMapper;
import com.coditas.learninganddevelopementservice.repository.AssignmentRepository;
import com.coditas.learninganddevelopementservice.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    private AssignmentRepository assignmentRepository;
    private AssignmentMapper assignmentMapper;
    private CourseRepository courseRepository;

    private AssignmentService(AssignmentRepository assignmentRepository, CourseRepository courseRepository, AssignmentMapper assignmentMapper) {
        this.assignmentRepository = assignmentRepository;
        this.assignmentMapper = assignmentMapper;
        this.courseRepository = courseRepository;
    }

    public AssignmentResponse createAssignment(long id, AssignmentRequest assignmentRequest) {
        Assignment assignment = assignmentMapper.toEntity(assignmentRequest);

        Course course = courseRepository.findById(id).orElseThrow(() ->
                new RuntimeException("CourseNot found")
        );
        assignment.setCourse(course);
        Assignment savedAssignment = assignmentRepository.save(assignment);
        return assignmentMapper.toDTO(savedAssignment);
    }
}
