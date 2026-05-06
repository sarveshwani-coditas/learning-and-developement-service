package com.coditas.learninganddevelopementservice.service;

import com.coditas.learninganddevelopementservice.dto.course.CourseRequest;
import com.coditas.learninganddevelopementservice.dto.course.CourseResponse;
import com.coditas.learninganddevelopementservice.entity.Course;
import com.coditas.learninganddevelopementservice.entity.Enrollment;
import com.coditas.learninganddevelopementservice.mapper.CourseMapper;
import com.coditas.learninganddevelopementservice.repository.CourseRepository;
import com.coditas.learninganddevelopementservice.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    private CourseMapper courseMapper;
    private EnrollmentRepository enrollmentRepository;

    public CourseService(CourseRepository courseRepository,EnrollmentRepository enrollmentRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper=courseMapper;
        this.enrollmentRepository=enrollmentRepository;
    }

    public CourseResponse createCourse(CourseRequest courseRequest) {
        Course course = courseMapper.toEntity(courseRequest);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toCourseResponse(savedCourse);
    }

    public CourseResponse findCourseById(long id) {
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new RuntimeException("course does not exist for id "+id)
        );
        return courseMapper.toCourseResponse(course);
    }

    public List<CourseResponse> findAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResponse> courseResponses =  courseMapper.toCourseResponse(courses);
        return courseResponses;
    }

    public List<CourseResponse> findAllCourseByEmployeeId(long id) {
        List<Enrollment> enrollments = enrollmentRepository.findByEmployeeId(id);

        List<Course> courses = new ArrayList<>();
        for(Enrollment e: enrollments){
            courses.add(e.getCourse());
        }

        return courseMapper.toCourseResponse(courses);
    }
}
