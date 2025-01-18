package com.server.backyaserver.domain.patient.controller;

import com.server.backyaserver.domain.healthStatus.dto.request.HealthStatusPostRequest;
import com.server.backyaserver.domain.member.domain.Member;
import com.server.backyaserver.domain.member.dto.response.MemberGetResponse;
import com.server.backyaserver.domain.patient.dto.request.PatientPostResponse;
import com.server.backyaserver.domain.patient.dto.response.PatientGetResponse;
import com.server.backyaserver.domain.patient.service.PatientHealthStatusService;
import com.server.backyaserver.domain.patient.service.PatientService;
import com.server.backyaserver.global.annotation.AuthUser;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final PatientHealthStatusService patientHealthStatusService;

    @GetMapping("/{memberId}")
    @Operation(summary = "보호자의 환자 정보 조회")
    public ResponseEntity<PatientGetResponse> getPatientsByMemberId(
            @PathVariable("memberId") Long id
    ) {
        return ResponseEntity.ok().body(patientService.getPatientByMemberId(id));
    }

    @GetMapping("")
    @Operation(summary = "(어드민용) 모든 환자 정보 조회")
    public ResponseEntity<List<PatientGetResponse>> getAllPatients(
    ) {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @PostMapping("")
    @Operation(summary = "(어드민용) 환자 정보 생성")
    public ResponseEntity<Long> createPatient(
            @RequestBody PatientPostResponse request
    ) {
        return ResponseEntity.ok().body(patientService.createPatient(request));
    }

    @PostMapping("/{patientId}/statuses")
    @Operation(summary = "(어드민용) 환자 건강 상태 생성")
    public ResponseEntity<Long> createPatientHealthStatus(
            @PathVariable("patientId") Long patientId,
            @RequestBody HealthStatusPostRequest request
    ) {
        return ResponseEntity.ok().body(patientHealthStatusService.createPatientHealthStatus(patientId, request));
    }
}
