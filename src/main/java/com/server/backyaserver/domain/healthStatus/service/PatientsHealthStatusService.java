package com.server.backyaserver.domain.healthStatus.service;

import com.server.backyaserver.domain.healthStatus.domain.HealthStatus;
import com.server.backyaserver.domain.healthStatus.dto.HealthStatusListResponse;
import com.server.backyaserver.domain.healthStatus.dto.HealthStatusResponse;
import com.server.backyaserver.domain.healthStatus.repository.PatientsHealthStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientsHealthStatusService {
    PatientsHealthStatusRepository patientsHealthStatusRepository;

    public HealthStatusListResponse getAllPatientsHealthStatus(Long id) {
        List<HealthStatus> statuses = patientsHealthStatusRepository.findAllByPatientId(id);
        List<HealthStatusResponse> statusesResponse = statuses.stream()
                .map(HealthStatusResponse:: from)
                .toList();
        return HealthStatusListResponse.from(statusesResponse);
    }
}
/*
@Transactional
    public LectureListResponseDto findLectures(){
        List<Lecture> lectures = lectureRepository.findAll();
        List<LectureResponseDto> lectureDtos = lectures.stream()
                .map(LectureResponseDto::from)
                .toList();//list로 출력하는 stream 사용?
        return LectureListResponseDto.from(lectureDtos);
 */
