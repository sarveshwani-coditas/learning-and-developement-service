package com.coditas.learninganddevelopementservice.controller;

import com.coditas.learninganddevelopementservice.dto.course.CourseRequest;
import com.coditas.learninganddevelopementservice.dto.course.CourseResponse;
import com.coditas.learninganddevelopementservice.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest courseRequest){
        CourseResponse courseResponse = courseService.createCourse(courseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable long id){
        CourseResponse courseResponse = courseService.findCourseById(id);
        return ResponseEntity.status(HttpStatus.OK).body(courseResponse);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourse(){
        List<CourseResponse> courseResponse = courseService.findAllCourses();
        return ResponseEntity.status(HttpStatus.OK).body(courseResponse);
    }

}
