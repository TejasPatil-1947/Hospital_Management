package com.hms.controllers;


import com.hms.Service.AppointmentService;
import com.hms.models.Appointment;
import com.hms.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/{patientId}/{doctorId}/{date}")
    public ResponseEntity<Appointment> createAppointment(@PathVariable Long patientId,@PathVariable Long doctorId,@PathVariable String date){
        Appointment appointment = appointmentService.createAppointment(patientId, doctorId, date);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }


}
