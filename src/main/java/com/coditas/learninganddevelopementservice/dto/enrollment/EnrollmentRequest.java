package com.coditas.learninganddevelopementservice.dto.enrollment;

import com.coditas.learninganddevelopementservice.entity.Course;
import com.coditas.learninganddevelopementservice.entity.Employee;
import com.coditas.learninganddevelopementservice.enums.EnrollmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EnrollmentRequest {

    @NotBlank
    private Integer employee_id;

    @NotBlank
    private Integer course_id;

    @NotBlank
    private EnrollmentStatus status;

    private LocalDate deadline;
}
