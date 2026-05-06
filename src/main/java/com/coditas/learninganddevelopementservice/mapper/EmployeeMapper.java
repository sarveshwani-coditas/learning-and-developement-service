package com.coditas.learninganddevelopementservice.mapper;


import com.coditas.learninganddevelopementservice.dto.employees.EmployeeRequest;
import com.coditas.learninganddevelopementservice.dto.employees.EmployeeResponse;
import com.coditas.learninganddevelopementservice.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, EnrollmentMapper.class})
public interface EmployeeMapper {
    Employee toEntity(EmployeeRequest employeeRequest);

    EmployeeResponse toDTO(Employee employee);

    List<EmployeeResponse> toDTOList(List<Employee> employees);
}
