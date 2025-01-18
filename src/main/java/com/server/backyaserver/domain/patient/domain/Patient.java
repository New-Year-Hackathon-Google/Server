package com.server.backyaserver.domain.patient.domain;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.member.domain.Member;
import com.server.backyaserver.global.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Patient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;

    private String name;
    private LocalDate dateOfBirth;
    private int roomNumber;
    private LocalDate entryDate;
    @Enumerated
    private BloodType bloodType;
    private String nurseName;
    private int weight;
    private int height;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "patient")
    private List<HealthStatus> healthStatusList = new ArrayList<>();

    @Builder
    public Patient(String name, LocalDate dateOfBirth, int roomNumber, LocalDate entryDate, BloodType bloodType,
                   String nurseName,
                   int weight, int height) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.roomNumber = roomNumber;
        this.entryDate = entryDate;
        this.bloodType = bloodType;
        this.nurseName = nurseName;
        this.weight = weight;
        this.height = height;
    }
}
