package com.server.backyaserver.domain.healthStatus.controller;


import com.server.backyaserver.domain.healthStatus.dto.response.HealthStatusGetResponse;
import com.server.backyaserver.domain.healthStatus.service.HealthStatusService;
import com.server.backyaserver.domain.member.domain.Member;
import com.server.backyaserver.domain.member.dto.response.MemberGetResponse;
import com.server.backyaserver.domain.patient.dto.request.PatientPostResponse;
import com.server.backyaserver.global.annotation.AuthUser;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/healthStatus")
@RequiredArgsConstructor
public class HealthStatusGetController {

    private final HealthStatusService healthStatusService;

    @GetMapping("/{patientId}")
    @Operation(summary = "최근 건강상태 조회", description = "보호자의 환자 최근 건강상태를 조회합니다.")
    public ResponseEntity<HealthStatusGetResponse> getRecentHealthStatusByPatientId(
            @PathVariable("patientId") Long patientId
    ) {
        return ResponseEntity.ok().body(healthStatusService.getRecentHealthStatusByPatientId(patientId));
    }


}
