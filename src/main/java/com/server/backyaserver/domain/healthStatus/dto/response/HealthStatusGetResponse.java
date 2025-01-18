package com.server.backyaserver.domain.healthStatus.dto.response;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.domain.Status;
import jakarta.persistence.Enumerated;
import lombok.Builder;

@Builder
public record HealthStatusGetResponse(
        Long id,
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

        public static HealthStatusGetResponse of(HealthStatus healthStatus) {
            return HealthStatusGetResponse.builder()
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
