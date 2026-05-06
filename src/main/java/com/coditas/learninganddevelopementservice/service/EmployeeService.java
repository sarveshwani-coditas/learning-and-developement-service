package com.coditas.learninganddevelopementservice.service;

import com.coditas.learninganddevelopementservice.dto.employees.EmployeeRequest;
import com.coditas.learninganddevelopementservice.dto.employees.EmployeeResponse;
import com.coditas.learninganddevelopementservice.entity.Employee;
import com.coditas.learninganddevelopementservice.entity.User;
import com.coditas.learninganddevelopementservice.enums.Status;
import com.coditas.learninganddevelopementservice.exception.ResourceNotFoundException;
import com.coditas.learninganddevelopementservice.mapper.EmployeeMapper;
import com.coditas.learninganddevelopementservice.mapper.UserMapper;
import com.coditas.learninganddevelopementservice.repository.EmployeeRepository;
import com.coditas.learninganddevelopementservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    private UserMapper userMapper;
    private UserRepository userRepository;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, UserMapper userMapper, UserRepository userRepository){
        this.employeeRepository=employeeRepository;
        this.employeeMapper=employeeMapper;
        this.userMapper=userMapper;
        this.userRepository=userRepository;
    }

    public EmployeeResponse registerEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.toEntity(employeeRequest);
        User user = userMapper.toEntity(employeeRequest.getUser());

        User savedUser = userRepository.save(user);
        Employee savedEmployee =  employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }

    public EmployeeResponse findEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not found")
        );
        return employeeMapper.toDTO(employee);
    }

    public List<EmployeeResponse> findAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toDTOList(employees);
    }

    public List<EmployeeResponse> findEmployeeByCourseId(long id) {
        List<Employee> employees = employeeRepository.findEmployeeByCourseId(id);

        return employeeMapper.toDTOList(employees);
    }

    public List<EmployeeResponse> getEmployees(Status status, Boolean doingCourse) {

        List<Employee> employees = new ArrayList<>();

        if(status==Status.BENCHED && Boolean.TRUE.equals(doingCourse)){
            employees = employeeRepository.findBenchedEmployeesDoingCourse(status);
        }
        else if(status==Status.BENCHED && Boolean.FALSE.equals(doingCourse)){
            employees = employeeRepository.findBenchedEmployeesNotDoingCourse(status);
        }
        return employeeMapper.toDTOList(employees);
    }
}
