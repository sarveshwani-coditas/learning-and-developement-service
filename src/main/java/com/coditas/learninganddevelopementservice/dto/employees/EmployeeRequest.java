package com.coditas.learninganddevelopementservice.dto.employees;

import com.coditas.learninganddevelopementservice.dto.user.UserRequest;
import com.coditas.learninganddevelopementservice.enums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeRequest {


    @NotBlank
    private String name;

    private Status status;

    private UserRequest user;
}
