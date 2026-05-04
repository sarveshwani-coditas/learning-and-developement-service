package com.coditas.learninganddevelopementservice.dto.user;

import com.coditas.learninganddevelopementservice.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    @NotNull
    private String username;

    @Email
    private String email;

    @Size(min = 4)
    private String password;

    private Role role;
}
