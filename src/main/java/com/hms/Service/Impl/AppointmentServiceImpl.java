package com.hms.Service.Impl;

import com.hms.Exception.DoctorNotFoundException;
import com.hms.Exception.PatientNotFoundException;
import com.hms.Service.AppointmentService;
import com.hms.models.Appointment;
import com.hms.models.Doctor;
import com.hms.models.Patient;
import com.hms.repository.AppointmentRepository;
import com.hms.repository.DoctorRepository;
import com.hms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;



    @Override
    public Appointment createAppointment(Long patientId, Long doctorId, String date) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + doctorId));

        Appointment ap = new Appointment();
        ap.setDate(date);
        ap.setDoctor(doctor);
        ap.setPatient(patient);

        return  appointmentRepository.save(ap);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return List.of();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return null;
    }
}
