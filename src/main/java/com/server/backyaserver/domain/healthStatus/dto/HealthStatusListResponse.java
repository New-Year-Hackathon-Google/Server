package com.server.backyaserver.domain.healthStatus.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class HealthStatusListResponse {
    private List<HealthStatusResponse> statusList;

    public static HealthStatusListResponse from(List<HealthStatusResponse> healthStatus) {
        return HealthStatusListResponse.builder()
                .statusList(healthStatus)
                .build();
    }
}

