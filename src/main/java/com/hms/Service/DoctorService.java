package com.hms.Service;

import com.hms.models.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor saveDoctor(Doctor doctor);

    Doctor updateDoctor(Long id,Doctor doctor);

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

//    List<Doctor> getDoctorBySpeciality(String speciality);
//
//    List<Doctor> getDoctorsByExperience(int experience);
}
