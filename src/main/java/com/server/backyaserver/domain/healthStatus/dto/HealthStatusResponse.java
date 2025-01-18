package com.server.backyaserver.domain.healthStatus.dto;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.domain.Status;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
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

    public static HealthStatusResponse of(HealthStatus healthStatus) {
        return new HealthStatusResponse(
                healthStatus.getId(),
                healthStatus.getPulse(),
                healthStatus.getBloodSugar(),
                healthStatus.getBloodHighPressure(),
                healthStatus.getBloodLowPressure(),
                healthStatus.getTemperature(),
                healthStatus.getBloodOxygen(),
                healthStatus.getDrugHistory(),
                healthStatus.getNotes(),
                healthStatus.getStatus()
        );
    }
}
