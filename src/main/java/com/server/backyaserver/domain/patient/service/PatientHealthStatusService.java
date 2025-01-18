package com.server.backyaserver.domain.patient.service;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.dto.request.HealthStatusPostRequest;
import com.server.backyaserver.domain.healthStatus.repository.HealthStatusRepository;
import com.server.backyaserver.domain.patient.domain.Patient;
import com.server.backyaserver.domain.patient.repository.PatientRepository;
import com.server.backyaserver.global.error.exception.ErrorCode;
import com.server.backyaserver.global.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientHealthStatusService {

    private final HealthStatusRepository healthStatusRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Long createPatientHealthStatus(Long patientId, HealthStatusPostRequest healthStatus){

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.PATIENT_NOT_FOUND));

        return healthStatusRepository.save(healthStatus.toEntity(patient)).getId();
    }
}
