package com.coditas.learninganddevelopementservice.service;

import com.coditas.learninganddevelopementservice.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository){
        this.enrollmentRepository=enrollmentRepository;
    }



}
