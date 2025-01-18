package com.server.backyaserver.domain.patient.dto.response;

import com.server.backyaserver.domain.patient.domain.BloodType;
import com.server.backyaserver.domain.patient.domain.Patient;
import java.time.LocalDate;

public record PatientGetResponse(
        Long id,
        String name,
        LocalDate dateOfBirth,
        int roomNumber,
        LocalDate entryDate,
        BloodType bloodType,
        String nurseName,
        int weight,
        int height
) {

    public static PatientGetResponse of(Patient patient) {
        return new PatientGetResponse(
                patient.getId(),
                patient.getName(),
                patient.getDateOfBirth(),
                patient.getRoomNumber(),
                patient.getEntryDate(),
                patient.getBloodType(),
                patient.getNurseName(),
                patient.getWeight(),
                patient.getHeight()
        );
    }
}
