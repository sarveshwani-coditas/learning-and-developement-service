package com.coditas.learninganddevelopementservice.repository;

import com.coditas.learninganddevelopementservice.dto.employees.EmployeeResponse;
import com.coditas.learninganddevelopementservice.entity.Employee;
import com.coditas.learninganddevelopementservice.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select distinct e from Employee e Join e.enrollment en where en.course.id = :id")
    List<Employee> findEmployeeByCourseId(long id);


    @Query("select distinct e from Employee e join e.enrollment en where e.status = :status")
    List<Employee> findBenchedEmployeesDoingCourse(Status status);

    @Query("select distinct e from Employee e where e.status = :status and e.enrollment is empty")
    List<Employee> findBenchedEmployeesNotDoingCourse(Status status);
}
