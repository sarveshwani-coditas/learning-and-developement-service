package com.coditas.learninganddevelopementservice.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseResponse {

    private Integer id;

    private String courseName;

    private Integer duration;

    private String ytLink;
}
