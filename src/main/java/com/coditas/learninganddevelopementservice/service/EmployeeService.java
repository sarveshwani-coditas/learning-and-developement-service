package com.coditas.learninganddevelopementservice.service;

import com.coditas.learninganddevelopementservice.dto.employees.EmployeeRequest;
import com.coditas.learninganddevelopementservice.dto.employees.EmployeeResponse;
import com.coditas.learninganddevelopementservice.entity.Employee;
import com.coditas.learninganddevelopementservice.mapper.EmployeeMapper;
import com.coditas.learninganddevelopementservice.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper){
        this.employeeRepository=employeeRepository;
        this.employeeMapper=employeeMapper;
    }

    public EmployeeResponse registerEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.toEntity(employeeRequest);
        Employee savedEmployee =  employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }

    public EmployeeResponse findEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("")
        );
        return employeeMapper.toDTO(employee);
    }

    public List<EmployeeResponse> findAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toDTOList(employees);
    }
}
