package com.coditas.learninganddevelopementservice.controller;

import com.coditas.learninganddevelopementservice.dto.employees.EmployeeRequest;
import com.coditas.learninganddevelopementservice.dto.employees.EmployeeResponse;
import com.coditas.learninganddevelopementservice.enums.Status;
import com.coditas.learninganddevelopementservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> registerEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse response = employeeService.registerEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable long id){
        EmployeeResponse employeeResponse = employeeService.findEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee(){
        List<EmployeeResponse> employeeResponse = employeeService.findAllEmployee();
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<List<EmployeeResponse>> getEmployeeByCourseId(@PathVariable long id){
        List<EmployeeResponse> employeeResponse = employeeService.findEmployeeByCourseId(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

    @GetMapping("filter")
    public ResponseEntity<List<EmployeeResponse>> getEmployees1(@RequestParam Status status,
                                                               @RequestParam Boolean doingCourse){
        List<EmployeeResponse> employeeResponse = employeeService.getEmployees(status, doingCourse);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

}
