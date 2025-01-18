package com.server.backyaserver.domain.healthStatus.service;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.dto.response.HealthStatusGetResponse;
import com.server.backyaserver.domain.healthStatus.repository.HealthStatusRepository;
import com.server.backyaserver.global.error.exception.ErrorCode;
import com.server.backyaserver.global.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HealthStatusService {

    private final HealthStatusRepository healthStatusRepository;

    @Transactional(readOnly = true)
    public HealthStatusGetResponse getRecentHealthStatusByPatientId(Long patientId) {
        HealthStatus healthStatus = healthStatusRepository.findLatestByPatientId(patientId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.HEALTH_STATUS_NOT_FOUND));
        return HealthStatusGetResponse.of(healthStatus);
    }
}
