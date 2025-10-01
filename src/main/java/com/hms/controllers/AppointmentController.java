package com.hms.controllers;


import com.hms.Dtos.AppointmentDTO;
import com.hms.Dtos.DtoMapper;
import com.hms.Service.AppointmentService;
import com.hms.models.Appointment;
import com.hms.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments(){
        List<Appointment> allAppointments = appointmentService.getAllAppointments();
        List<AppointmentDTO> list = allAppointments.stream().map(DtoMapper::toAppointmentDTO).toList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long  id){
        Appointment appointmentById = appointmentService.getAppointmentById(id);
        return new ResponseEntity<>(DtoMapper.toAppointmentDTO(appointmentById),HttpStatus.OK);
    }


}
