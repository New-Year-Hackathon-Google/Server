package com.server.backyaserver.domain.healthStatus.repository;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HealthStatusRepository extends JpaRepository<HealthStatus, Long> {
    @Query("SELECT h FROM HealthStatus h WHERE h.patient.id = :patientId ORDER BY h.createdDate DESC")
    HealthStatus findLatestByPatientId(@Param("patientId") Long patientId);
}
