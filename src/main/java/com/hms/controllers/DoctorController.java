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
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        List<Doctor> allDoctors = doctorService.getAllDoctors();
        List<DoctorDTO> list = allDoctors.stream().map(DtoMapper::toDoctorDTO).toList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<DoctorDTO> saveDoctor(@RequestBody Doctor doctor){
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(DtoMapper.toDoctorDTO(savedDoctor),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id){
        Doctor doctorById = doctorService.getDoctorById(id);
        return new ResponseEntity<>(DtoMapper.toDoctorDTO(doctorById),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long id,@RequestBody Doctor doctor){
        Doctor updateDoctor = doctorService.updateDoctor(id, doctor);
        return new ResponseEntity<>(DtoMapper.toDoctorDTO(updateDoctor),HttpStatus.OK);
    }

}
