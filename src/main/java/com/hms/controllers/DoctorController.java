package com.hms.controllers;

import com.hms.Dtos.DoctorDTO;
import com.hms.Dtos.DtoMapper;
import com.hms.Service.DoctorService;
import com.hms.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController{

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
//        List<Doctor> allDoctors = doctorService.getAllDoctors();
//        List<DoctorDTO> list = allDoctors.stream().map(DtoMapper::toDoctorDTO).toList();
//        return new ResponseEntity<>(list,HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
        return new ResponseEntity<>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id){
        return new ResponseEntity<>(doctorService.getDoctorById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id,@RequestBody Doctor doctor){
        return new ResponseEntity<>(doctorService.updateDoctor(id,doctor),HttpStatus.OK);
    }

}
