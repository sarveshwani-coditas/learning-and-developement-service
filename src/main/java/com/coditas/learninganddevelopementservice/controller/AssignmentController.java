package com.coditas.learninganddevelopementservice.controller;

import com.coditas.learninganddevelopementservice.dto.assignment.AssignmentRequest;
import com.coditas.learninganddevelopementservice.dto.assignment.AssignmentResponse;
import com.coditas.learninganddevelopementservice.entity.Assignment;
import com.coditas.learninganddevelopementservice.service.AssignmentService;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class AssignmentController {

    private AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService){
        this.assignmentService=assignmentService;
    }

    @PostMapping("courses/{courseID}/assignments")
    public ResponseEntity<AssignmentResponse> createAssignment(@PathVariable long courseID, @RequestBody AssignmentRequest assignmentRequest){
        AssignmentResponse response = assignmentService.createAssignment(courseID, assignmentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("employees/{empId}/courses/{courseId}/assignments")
    public ResponseEntity<AssignmentResponse> getAssignment(@PathVariable long empId, @PathVariable long courseId){
        AssignmentResponse response = assignmentService.getAssignment(empId, courseId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
