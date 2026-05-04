package com.coditas.learninganddevelopementservice.mapper;

import com.coditas.learninganddevelopementservice.dto.assignment.AssignmentRequest;
import com.coditas.learninganddevelopementservice.dto.assignment.AssignmentResponse;
import com.coditas.learninganddevelopementservice.dto.user.UserRequest;
import com.coditas.learninganddevelopementservice.dto.user.UserResponse;
import com.coditas.learninganddevelopementservice.entity.Assignment;
import com.coditas.learninganddevelopementservice.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    Assignment toEntity(AssignmentRequest assignmentRequest);

    AssignmentResponse toDTO(Assignment assignment);

    List<AssignmentResponse> toDTOList(List<Assignment> assignment);
}
