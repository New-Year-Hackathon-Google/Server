package com.server.backyaserver.domain.healthStatus.domain;

import com.server.backyaserver.domain.patient.domain.Patient;
import com.server.backyaserver.global.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HealthStatus extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "health_status_id")
    private Long id;

    private Double pulse;
    private Double bloodSugar;
    private Double bloodHighPressure;
    private Double bloodLowPressure;
    private Double temperature;
    private Double bloodOxygen;
    private String drugHistory;
    private String notes;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Builder
    public HealthStatus(Double pulse, Double bloodSugar, Double bloodHighPressure, Double bloodLowPressure,

                        Double temperature, Double bloodOxygen, String drugHistory, String notes, LocalDate date,
                        Status status, Patient patient) {

        this.pulse = pulse;
        this.bloodSugar = bloodSugar;
        this.bloodHighPressure = bloodHighPressure;
        this.bloodLowPressure = bloodLowPressure;
        this.temperature = temperature;
        this.bloodOxygen = bloodOxygen;
        this.drugHistory = drugHistory;
        this.notes = notes;
        this.status = status;
        this.patient = patient;
    }
}
