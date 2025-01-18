package com.server.backyaserver.domain.healthStatus.repository;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.service.PatientsHealthStatusService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientsHealthStatusRepository extends JpaRepository<HealthStatus, Long> {
    List<HealthStatus> findAllByPatientId(Long patientId);
}
