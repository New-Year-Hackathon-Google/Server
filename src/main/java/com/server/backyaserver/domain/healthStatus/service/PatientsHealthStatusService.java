package com.server.backyaserver.domain.healthStatus.service;

import com.server.backyaserver.domain.healthStatus.dto.HealthStatusResponse;
import com.server.backyaserver.domain.healthStatus.repository.PatientsHealthStatusRepository;
import com.server.backyaserver.domain.patient.repository.PatientRepository;
import com.server.backyaserver.global.error.exception.ErrorCode;
import com.server.backyaserver.global.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientsHealthStatusService {
    private final PatientsHealthStatusRepository patientsHealthStatusRepository;
    private final PatientRepository patientRepository;

    @Transactional(readOnly = true)
    public List<HealthStatusResponse> getAllPatientsHealthStatus(Long patientId) {
        patientRepository.findById(patientId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.PATIENT_NOT_FOUND));

        return patientsHealthStatusRepository.findAllByPatientId(patientId).stream()
                .map(HealthStatusResponse::of)
                .toList();
    }
}
