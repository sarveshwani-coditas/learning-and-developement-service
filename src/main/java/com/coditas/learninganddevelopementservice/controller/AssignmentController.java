package com.coditas.learninganddevelopementservice.controller;

import com.coditas.learninganddevelopementservice.entity.Assignment;
import org.springframework.expression.spel.ast.Assign;

public class AssignmentController {

    private AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService){
        this.assignmentService=assignmentService;
    }


}
