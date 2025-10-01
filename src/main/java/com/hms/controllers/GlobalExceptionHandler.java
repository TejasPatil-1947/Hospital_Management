package com.hms.controllers;

import com.hms.Exception.DoctorNotFoundException;
import com.hms.Exception.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePatientNotFoundException(PatientNotFoundException ex){
        Map<String,Object> error = new HashMap<>();
        error.put("TimeStamp", LocalDateTime.now());
        error.put("Description",ex.getMessage());
        error.put("Status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleDoctorNotFoundException(DoctorNotFoundException ex){
        Map<String,Object> error = new HashMap<>();
        error.put("TimeStamp", LocalDate.now());
        error.put("Description",ex.getCause());
        error.put("Status",HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }
}
