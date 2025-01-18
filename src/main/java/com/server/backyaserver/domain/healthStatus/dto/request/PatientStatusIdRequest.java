package com.server.backyaserver.domain.healthStatus.dto.request;

public record PatientStatusIdRequest(
        Long patientId,
        Long statusId
) {
}
