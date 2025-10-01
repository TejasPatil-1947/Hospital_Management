package com.hms.Dtos;

import java.time.LocalDateTime;

public class BillDTO {

    private Long id;

    private Double amount;

    private String description;

    private LocalDateTime billingDate;

    private String status;

    private Long patientId;

    private Long appointmentId;

    public BillDTO() {
    }

    @Override
    public String toString() {
        return "BillDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", billingDate=" + billingDate +
                ", status='" + status + '\'' +
                ", patientId=" + patientId +
                ", appointmentId=" + appointmentId +
                '}';
    }

    public BillDTO(Long id, Double amount, String description, LocalDateTime billingDate, String status, Long patientId, Long appointmentId) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.billingDate = billingDate;
        this.status = status;
        this.patientId = patientId;
        this.appointmentId = appointmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDateTime billingDate) {
        this.billingDate = billingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
}
