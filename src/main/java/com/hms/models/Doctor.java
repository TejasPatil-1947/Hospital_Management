package com.hms.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Doctor_ID")
    private Long id;

    private String name;

    private String Speciality;

    private Double consultationFee;

    private int Experience;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Appointment> appointments;

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Speciality='" + Speciality + '\'' +
                ", consultationFee=" + consultationFee +
                ", Experience=" + Experience +
                ", appointments=" + appointments +
                '}';
    }

    public Doctor() {
    }

    public Doctor(Long id, String name, String speciality, Double consultationFee, int experience, List<Appointment> appointments) {
        this.id = id;
        this.name = name;
        Speciality = speciality;
        this.consultationFee = consultationFee;
        Experience = experience;
        this.appointments = appointments;
    }

    public Double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Double consultationFee) {
        this.consultationFee = consultationFee;
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

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }
}
