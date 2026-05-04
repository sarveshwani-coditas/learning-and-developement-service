package com.coditas.learninganddevelopementservice.dto.course;

import com.coditas.learninganddevelopementservice.entity.Assignment;
import com.coditas.learninganddevelopementservice.entity.Enrollment;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CourseRequest {

    @NotBlank
    private String courseName;

    @Positive
    private Integer duration;

    @NotBlank
    private String ytLink;


}
