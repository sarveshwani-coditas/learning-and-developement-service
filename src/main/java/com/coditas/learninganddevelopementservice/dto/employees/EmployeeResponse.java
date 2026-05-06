package com.coditas.learninganddevelopementservice.dto.employees;

import com.coditas.learninganddevelopementservice.dto.enrollment.EnrollmentResponse;
import com.coditas.learninganddevelopementservice.dto.user.UserResponse;
import com.coditas.learninganddevelopementservice.enums.Role;
import com.coditas.learninganddevelopementservice.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeResponse {

    private Integer id;

    private String name;

    private Status status;

    private UserResponse user;

//    private List<EnrollmentResponse> enrollment;
}
