package com.server.backyaserver.domain.member.Controller;

import com.server.backyaserver.domain.member.dto.response.MemberGetResponse;
import com.server.backyaserver.domain.member.domain.Member;
import com.server.backyaserver.global.annotation.AuthUser;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.OneToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/me")
    @Operation(summary = "보호자(자기자신) 정보 조회")
    public ResponseEntity<MemberGetResponse> memberInfo(
            @AuthUser Member member
            ) {
        return ResponseEntity.ok().body(MemberGetResponse.of(member));
    }
}
