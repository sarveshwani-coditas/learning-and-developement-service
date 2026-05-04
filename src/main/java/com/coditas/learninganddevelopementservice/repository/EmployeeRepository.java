package com.coditas.learninganddevelopementservice.repository;

import com.coditas.learninganddevelopementservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
