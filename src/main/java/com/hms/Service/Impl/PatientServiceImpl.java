package com.hms.Service.Impl;

import com.hms.Exception.PatientNotFoundException;
import com.hms.Service.PatientService;
import com.hms.models.Patient;
import com.hms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {


    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Patient savePatient(Patient patient) {
        Patient p = new Patient();
        p.setName(patient.getName());
        p.setAge(patient.getAge());
        p.setDob(patient.getDob());
        p.setGender(patient.getGender());
        p.setStatus(patient.getStatus());
        p.setPhoneNumber(patient.getPhoneNumber());
        p.setMedicalHistory(patient.getMedicalHistory());
        p.setAppointments(patient.getAppointments());
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() ->new
                PatientNotFoundException("Patient Not Found With ID: " + id));
    }

    @Override
    public Patient updatePatientDetails(Long id,Patient patient) {
        Patient incomingPatient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));
        incomingPatient.setName(patient.getName());
        incomingPatient.setAge(patient.getAge());
        incomingPatient.setDob(patient.getDob());
        incomingPatient.setGender(patient.getGender());
        incomingPatient.setMedicalHistory(patient.getMedicalHistory());
        incomingPatient.setPhoneNumber(patient.getPhoneNumber());
        incomingPatient.setStatus(patient.getStatus());
        return patientRepository.save(incomingPatient);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient with id: " + id + "not found"));
        patientRepository.delete(patient);
    }
}
