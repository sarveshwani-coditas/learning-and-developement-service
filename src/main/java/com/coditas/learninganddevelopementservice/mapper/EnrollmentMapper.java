package com.coditas.learninganddevelopementservice.mapper;

import com.coditas.learninganddevelopementservice.dto.enrollment.EnrollmentRequest;
import com.coditas.learninganddevelopementservice.dto.enrollment.EnrollmentResponse;
import com.coditas.learninganddevelopementservice.dto.user.UserRequest;
import com.coditas.learninganddevelopementservice.dto.user.UserResponse;
import com.coditas.learninganddevelopementservice.entity.Enrollment;
import com.coditas.learninganddevelopementservice.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    Enrollment toEntity(EnrollmentRequest enrollmentRequest);

    EnrollmentResponse toDTO(Enrollment enrollment);

    List<EnrollmentResponse> toDTOList(List<Enrollment> enrollments);
}
