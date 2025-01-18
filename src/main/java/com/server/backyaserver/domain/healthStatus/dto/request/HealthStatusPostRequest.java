package com.server.backyaserver.domain.healthStatus.dto.request;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.domain.Status;
import com.server.backyaserver.domain.patient.domain.Patient;

public record HealthStatusPostRequest(
        Double pulse,
        Double bloodSugar,
        Double bloodHighPressure,
        Double bloodLowPressure,
        Double temperature,
        Double bloodOxygen,
        String drugHistory,
        String notes,
        Status status
) {
    public HealthStatus toEntity(Patient patient) {
        return HealthStatus.builder()
                .pulse(pulse)
                .bloodSugar(bloodSugar)
                .bloodHighPressure(bloodHighPressure)
                .bloodLowPressure(bloodLowPressure)
                .temperature(temperature)
                .bloodOxygen(bloodOxygen)
                .drugHistory(drugHistory)
                .notes(notes)
                .status(status)
                .patient(patient)
                .build();
    }
}
