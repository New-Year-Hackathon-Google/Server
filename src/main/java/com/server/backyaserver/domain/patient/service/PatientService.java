package com.server.backyaserver.domain.patient.service;

import com.server.backyaserver.domain.patient.dto.request.PatientPostResponse;
import com.server.backyaserver.domain.patient.dto.response.PatientGetResponse;
import com.server.backyaserver.domain.patient.repository.PatientRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional(readOnly = true)
    public List<PatientGetResponse> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(PatientGetResponse::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public PatientGetResponse getPatientByMemberId(Long memberId) {
        return PatientGetResponse.of(patientRepository.findByMemberIdOrThrow(memberId));
    }

    @Transactional
    public Long createPatient(PatientPostResponse request) {
        return patientRepository.save(request.toEntity()).getId();
    }
}
