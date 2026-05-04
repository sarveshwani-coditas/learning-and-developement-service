package com.coditas.learninganddevelopementservice.dto.user;

import com.coditas.learninganddevelopementservice.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private Integer id;

    private String username;

    private String email;

    private Role role;
}
