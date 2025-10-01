package com.hms.Dtos;

import com.hms.models.Appointment;
import com.hms.models.Bill;
import com.hms.models.Doctor;
import com.hms.models.Patient;

import java.util.stream.Collectors;

public class DtoMapper {


    public static DoctorDTO toDoctorDTO(Doctor doctor) {
        if (doctor == null) return null;
        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpeciality(doctor.getSpeciality());
        dto.setExperience(doctor.getExperience());
        dto.setConsultationFee(doctor.getConsultationFee());
        return dto;
    }

    public static AppointmentDTO toAppointmentDTO(Appointment appointment) {
        if (appointment == null) return null;
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setDate(appointment.getDate());
        dto.setDoctor(toDoctorDTO(appointment.getDoctor()));
        return dto;
    }

    public static BillDTO toBillDTO(Bill bill){
        if(bill == null)  return null;
        BillDTO billDTO = new BillDTO();
        billDTO.setId(bill.getId());
//        billDTO.setAppointmentId(bill.getAppointment() != null ?);
        if(bill.getAppointment() != null){
            billDTO.setAppointmentId(bill.getAppointment().getId());
        }
//        billDTO.setPatientId(bill.getPatient().getId());
        if(bill.getPatient() != null){
            billDTO.setPatientId(bill.getPatient().getId());
        }
        System.out.println(bill.getPatient().getId());
        billDTO.setDescription(bill.getDescription());
        billDTO.setBillingDate(bill.getBillingDate());
        billDTO.setAmount(bill.getAmount());
        billDTO.setStatus(bill.getStatus());
        System.out.println(billDTO);
        return billDTO;
    }

    public static PatientDTO toPatientDTO(Patient patient) {
        if (patient == null) return null;
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setGender(patient.getGender());
        dto.setAge(patient.getAge());
        dto.setDob(patient.getDob().toString());
        dto.setPhoneNumber(patient.getPhoneNumber());
        dto.setMedicalHistory(patient.getMedicalHistory());
        dto.setStatus(patient.getStatus());
        if (patient.getAppointments() != null) {
            dto.setAppointments(patient.getAppointments().stream()
                    .map(DtoMapper::toAppointmentDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }
}
