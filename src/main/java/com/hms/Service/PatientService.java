package com.hms.Service;


import com.hms.models.Patient;

import java.util.List;

public interface PatientService {

    Patient savePatient(Patient patient);
    List<Patient> getAllPatient();
    Patient getPatientById(Long id);
    Patient updatePatientDetails(Long id,Patient patient);
    void deletePatient(Long id);
}
