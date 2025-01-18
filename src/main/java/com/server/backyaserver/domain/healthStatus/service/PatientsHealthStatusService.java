package com.server.backyaserver.domain.healthStatus.service;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.dto.HealthStatusResponse;
import com.server.backyaserver.domain.healthStatus.repository.PatientsHealthStatusRepository;
import com.server.backyaserver.global.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientsHealthStatusService {
    PatientsHealthStatusRepository patientsHealthStatusRepository;

    @Transactional(readOnly = true)
    public List<HealthStatusResponse> getAllPatientsHealthStatus(Long id) {
        return patientsHealthStatusRepository.findAllByPatientId(id).stream()
                .map(HealthStatusResponse::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public HealthStatusResponse getPatientsHealthStatusById(Long statusId, Long patientId) {

        HealthStatus healthStatus = patientsHealthStatusRepository.findByIdAndPatientId(statusId, patientId).
                orElseThrow(() -> new NotFoundException(ErrorCode."Patient not found"));
        ;
        return HealthStatusResponse.of(healthStatus);
    }
}
