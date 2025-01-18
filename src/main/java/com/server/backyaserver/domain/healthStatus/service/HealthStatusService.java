package com.server.backyaserver.domain.healthStatus.service;

import com.server.backyaserver.domain.healthStatus.dto.response.HealthStatusGetResponse;
import com.server.backyaserver.domain.healthStatus.repository.HealthStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HealthStatusService {

    private final HealthStatusRepository healthStatusRepository;

    @Transactional(readOnly = true)
    public HealthStatusGetResponse getRecentHealthStatusByPatientId(Long patientId) {
        return HealthStatusGetResponse.of(healthStatusRepository.findLatestByPatientId(patientId));
    }
}
