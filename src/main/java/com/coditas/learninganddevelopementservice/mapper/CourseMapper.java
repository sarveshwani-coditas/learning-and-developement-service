package com.coditas.learninganddevelopementservice.mapper;

import com.coditas.learninganddevelopementservice.dto.course.CourseRequest;
import com.coditas.learninganddevelopementservice.dto.course.CourseResponse;
import com.coditas.learninganddevelopementservice.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CourseRequest courseRequest);

    CourseResponse toCourseResponse(Course course);

    List<CourseResponse> toCourseResponse(List<Course> courses);
}
