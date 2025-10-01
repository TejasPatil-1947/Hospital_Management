package com.hms.Service;

import com.hms.models.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {

    Appointment createAppointment(Long patientId, Long doctorId, String date);

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Long id);
}
