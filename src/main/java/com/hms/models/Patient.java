package com.hms.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Patient_ID")
    private Long id;

    private String name;

    private String gender;

    private int age;

    private LocalDate dob;

    private String phoneNumber;

    private String medicalHistory;

    private String status;


    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Appointment> appointments;

    public Patient() {
    }


    public Patient(Long id, String name, String gender, int age, LocalDate dob, String phoneNumber, String medicalHistory, String status, List<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.medicalHistory = medicalHistory;
        this.status = status;
        this.appointments = appointments;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

