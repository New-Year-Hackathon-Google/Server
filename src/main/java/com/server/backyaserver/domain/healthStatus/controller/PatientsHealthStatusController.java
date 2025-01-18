package com.server.backyaserver.domain.healthStatus.controller;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.dto.HealthStatusResponse;
import com.server.backyaserver.domain.healthStatus.dto.request.PatientIdRequest;
import com.server.backyaserver.domain.healthStatus.dto.request.PatientStatusIdRequest;
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

    @PostMapping("/statuses")
    @Operation(summary = "건강상태 리스트 조회", description = "보호자의 환자 건강상태 리스트를 조회합니다.")
    public ResponseEntity<List<HealthStatusResponse>> getListHealthStatusByPatientId(
            @RequestBody PatientIdRequest request
    ){
        return ResponseEntity.ok().body(patientsHealthStatusService.getAllPatientsHealthStatus(request.patientId()));
    }

    @PostMapping("/statuses/one")
    @Operation(summary = "건강 상태 단일 조회", description = "보호자의 환자 건강상태 단일건을 조회합니다.")
    public ResponseEntity<HealthStatusResponse> getHealthStatusByPatientId(
            @RequestBody PatientStatusIdRequest request
   ){
        return ResponseEntity.ok().body(patientsHealthStatusService.getPatientsHealthStatus(request.statusId(),
                request.patientId()));
    }



}
