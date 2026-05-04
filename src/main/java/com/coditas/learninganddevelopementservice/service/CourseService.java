package com.coditas.learninganddevelopementservice.service;

import com.coditas.learninganddevelopementservice.dto.course.CourseRequest;
import com.coditas.learninganddevelopementservice.dto.course.CourseResponse;
import com.coditas.learninganddevelopementservice.entity.Course;
import com.coditas.learninganddevelopementservice.mapper.CourseMapper;
import com.coditas.learninganddevelopementservice.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    private CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper=courseMapper;
    }

    public CourseResponse createCourse(CourseRequest courseRequest) {
        Course course = courseMapper.toCourse(courseRequest);
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
}
