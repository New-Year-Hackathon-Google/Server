package com.server.backyaserver.domain.healthStatus.controller;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.dto.HealthStatusResponse;
import com.server.backyaserver.domain.healthStatus.dto.response.HealthStatusGetResponse;
import com.server.backyaserver.domain.healthStatus.service.PatientsHealthStatusService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vi/patient")
@RequiredArgsConstructor
public class PatientsHealthStatusController {

    private final PatientsHealthStatusService patientsHealthStatusService;

    @GetMapping("/{patientId}/statuses")
    @Operation(summary = "건강상태 리스트 조회", description = "보호자의 환자 건강상태 리스트를 조회합니다.")
    public ResponseEntity<List<HealthStatusResponse>> getListHealthStatusByPatientId(@PathVariable("patientId") Long patientId){
        return ResponseEntity.ok().body(patientsHealthStatusService.getAllPatientsHealthStatus(patientId));
    }

    @GetMapping("/{patientId}/statuses/{statusId}")
    @Operation(summary = "건강 상태 단일 조회", description = "보호자의 환자 건강상태 단일건을 조회합니다.")
    public ResponseEntity<HealthStatusResponse> getHealthStatusByPatientId(@PathVariable("statusId") Long statusId, @PathVariable("patientId") Long patientId){
        return ResponseEntity.ok().body(patientsHealthStatusService.getPatientHealthStatus(statusId, patientId));
    }



}
