package com.server.backyaserver.domain.patient.repository;

import com.server.backyaserver.domain.member.domain.Member;
import com.server.backyaserver.domain.patient.domain.Patient;
import com.server.backyaserver.global.error.exception.ErrorCode;
import com.server.backyaserver.global.error.exception.NotFoundException;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByMemberId(Long memberId);

    default Patient findByMemberIdOrThrow(Long memberId) {
        return findByMemberId(memberId).orElseThrow(() -> new NotFoundException(ErrorCode.PATIENT_NOT_FOUND));
    }
}
