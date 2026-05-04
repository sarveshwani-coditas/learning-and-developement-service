package com.coditas.learninganddevelopementservice.dto.enrollment;

import com.coditas.learninganddevelopementservice.dto.course.CourseResponse;
import com.coditas.learninganddevelopementservice.dto.employees.EmployeeResponse;
import com.coditas.learninganddevelopementservice.enums.EnrollmentStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EnrollmentResponse {

    private EmployeeResponse employee;

    private CourseResponse course;

    private EnrollmentStatus status;

    private LocalDate deadline;
}
