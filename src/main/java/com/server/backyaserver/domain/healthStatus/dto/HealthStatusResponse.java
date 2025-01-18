package com.server.backyaserver.domain.healthStatus.dto;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.domain.Status;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class HealthStatusResponse {

    private Long id;
    private Double pulse;
    private Double bloodSugar;
    private Double bloodHighPressure;
    private Double bloodLowPressure;
    private Double temperature;
    private Double bloodOxygen;
    private String drugHistory;
    private String notes;

    @Enumerated
    private Status status;

    public static HealthStatusResponse from(HealthStatus healthStatus) {
        return HealthStatusResponse.builder()
                .id(healthStatus.getId())
                .pulse(healthStatus.getPulse())
                .bloodSugar(healthStatus.getBloodSugar())
                .bloodHighPressure(healthStatus.getBloodHighPressure())
                .bloodLowPressure(healthStatus.getBloodLowPressure())
                .temperature(healthStatus.getTemperature())
                .bloodOxygen(healthStatus.getBloodOxygen())
                .drugHistory(healthStatus.getDrugHistory())
                .notes(healthStatus.getNotes())
                .status(healthStatus.getStatus())
                .build();
    }
}
