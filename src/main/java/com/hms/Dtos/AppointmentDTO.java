package com.hms.Dtos;

public class AppointmentDTO {

        private Long id;
        private String date;
        private DoctorDTO doctor;


        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }

        public DoctorDTO getDoctor() { return doctor; }
        public void setDoctor(DoctorDTO doctor) { this.doctor = doctor; }
}

