package com.coditas.learninganddevelopementservice.controller;

import com.coditas.learninganddevelopementservice.dto.enrollment.EnrollmentRequest;
import com.coditas.learninganddevelopementservice.dto.enrollment.EnrollmentResponse;
import com.coditas.learninganddevelopementservice.service.EnrollmentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EnrollmentController {

    private EnrollmentService enrollmentService;
    public EnrollmentController(EnrollmentService enrollmentService){
        this.enrollmentService= enrollmentService;
    }

    @PostMapping("/enrollments")
    public ResponseEntity<EnrollmentResponse> enroll(@RequestBody EnrollmentRequest enrollmentRequest){
        EnrollmentResponse response = enrollmentService.enroll(enrollmentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/enrollments")
    public ResponseEntity<List<EnrollmentResponse>> getAllEnrollments(){
        List<EnrollmentResponse> response = enrollmentService.getAllEnrollments();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
