package com.hms.controllers;

import com.hms.Dtos.DtoMapper;
import com.hms.Dtos.PatientDTO;
import com.hms.Service.Impl.PatientServiceImpl;
import com.hms.Service.PatientService;
import com.hms.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        List<Patient> allPatient = patientService.getAllPatient();
        List<PatientDTO> collect = allPatient.stream().map(DtoMapper::toPatientDTO).collect(Collectors.toList());
        return new ResponseEntity<>(collect,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody Patient patient){
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(DtoMapper.toPatientDTO(savedPatient),HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        Patient patientById = patientService.getPatientById(id);
        return new ResponseEntity<>(DtoMapper.toPatientDTO(patientById),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id,@RequestBody Patient patient){
        Patient updatedPatient = patientService.updatePatientDetails(id, patient);
        return new ResponseEntity<>(DtoMapper.toPatientDTO(updatedPatient),HttpStatus.OK);
    }

}
