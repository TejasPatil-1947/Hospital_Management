package com.hms.Dtos;

public class DoctorDTO {
    private Long id;
    private String name;
    private String speciality;
    private int experience;

    private Double consultationFee;

    public Double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
}
