package com.hms.Service.Impl;

import com.hms.Exception.DoctorNotFoundException;
import com.hms.Exception.PatientNotFoundException;
import com.hms.Service.AppointmentService;
import com.hms.models.Appointment;
import com.hms.models.Bill;
import com.hms.models.Doctor;
import com.hms.models.Patient;
import com.hms.repository.AppointmentRepository;
import com.hms.repository.BillRepository;
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


    @Autowired
    private BillRepository billRepository;

    @Override
    public Appointment createAppointment(Long patientId, Long doctorId, String date) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + doctorId));
        doctor.setConsultationFee(800.0);
        doctorRepository.save(doctor);
        Appointment ap = new Appointment();
        ap.setDate(date);
        ap.setDoctor(doctor);
        ap.setPatient(patient);


        Bill bill = new Bill();
        bill.setId(ap.getId());
        bill.setPatient(patient);
        bill.setAppointment(ap);
        bill.setBillingDate(LocalDateTime.now());
        bill.setDescription("Consultation Fee");
        bill.setStatus("Pending");
        bill.setAmount(doctor.getConsultationFee());
        Appointment save = appointmentRepository.save(ap);
        billRepository.save(bill);
        return save;

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
