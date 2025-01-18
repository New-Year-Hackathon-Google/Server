package com.server.backyaserver.domain.patient.dto.request;

import com.server.backyaserver.domain.patient.domain.BloodType;
import com.server.backyaserver.domain.patient.domain.Patient;
import java.time.LocalDate;

public record PatientPostResponse(
        String name,
        LocalDate dateOfBirth,
        int roomNumber,
        LocalDate entryDate,
        BloodType bloodType,
        String nurseName,
        int weight,
        int height
) {
    public Patient toEntity() {
        return Patient.builder()
                .name(name)
                .dateOfBirth(dateOfBirth)
                .roomNumber(roomNumber)
                .entryDate(entryDate)
                .bloodType(bloodType)
                .nurseName(nurseName)
                .weight(weight)
                .height(height)
                .build();
    }
}
