package com.hms.Service.Impl;

import com.hms.Exception.DoctorNotFoundException;
import com.hms.Service.DoctorService;
import com.hms.models.Doctor;
import com.hms.models.Patient;
import com.hms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {


    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        Doctor d = new Doctor();
        d.setName(doctor.getName());
        d.setExperience(doctor.getExperience());
        d.setSpeciality(doctor.getSpeciality());
        return doctorRepository.save(d);
    }

    @Override
    public Doctor updateDoctor(Long id,Doctor doctor) {

        Doctor incomingDoctor = doctorRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException("Doctor Not Found with ID:  " + id));
        incomingDoctor.setName(doctor.getName());
        incomingDoctor.setSpeciality(doctor.getSpeciality());
        incomingDoctor.setExperience(doctor.getExperience());
        incomingDoctor.setConsultationFee(doctor.getConsultationFee());
        Doctor save = doctorRepository.save(incomingDoctor);

        System.out.println(save);
        return save;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException("Doctor not found with ID: " + id));
    }

//    @Override
//    public List<Doctor> getDoctorBySpeciality(String speciality) {
//        return doctorRepository.findBySpeciality(speciality);
//    }
//
//    @Override
//    public List<Doctor> getDoctorsByExperience(int experience) {
//        return doctorRepository.findByExperience(experience);
//    }
}
