package com.coditas.learninganddevelopementservice.exception;

public class CourseNotCompleteException extends RuntimeException {
    public CourseNotCompleteException(String message) {
        super(message);
    }
}
