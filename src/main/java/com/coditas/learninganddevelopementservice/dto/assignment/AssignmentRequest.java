package com.coditas.learninganddevelopementservice.dto.assignment;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AssignmentRequest {

    @NotBlank
    private String AssignmentName;

    @Positive
    private Integer totalMarks;
}
