package com.coditas.learninganddevelopementservice.dto.assignment;

import com.coditas.learninganddevelopementservice.dto.course.CourseResponse;
import com.coditas.learninganddevelopementservice.entity.Course;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AssignmentResponse {

    private Long id;

    private Course course;

    private String AssignmentName;

    private Integer totalMarks;
}
