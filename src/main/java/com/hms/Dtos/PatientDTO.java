package com.hms.Dtos;

import java.util.List;

public class PatientDTO {

        private Long id;
        private String name;
        private String gender;
        private int age;
        private String dob;
        private String phoneNumber;
        private String medicalHistory;
        private String status;
        private List<AppointmentDTO> appointments;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public String getDob() { return dob; }
        public void setDob(String dob) { this.dob = dob; }

        public String getPhoneNumber() { return phoneNumber; }
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

        public String getMedicalHistory() { return medicalHistory; }
        public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public List<AppointmentDTO> getAppointments() { return appointments; }
        public void setAppointments(List<AppointmentDTO> appointments) { this.appointments = appointments; }
}

