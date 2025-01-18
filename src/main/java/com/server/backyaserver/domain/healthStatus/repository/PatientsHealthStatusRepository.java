package com.server.backyaserver.domain.healthStatus.repository;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.service.PatientsHealthStatusService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientsHealthStatusRepository extends JpaRepository<HealthStatus, Long> {
    List<HealthStatus> findAllByPatientId(Long patientId);
    Optional<HealthStatus> findByIdAndPatientId(Long statusId, Long patientId);
}
