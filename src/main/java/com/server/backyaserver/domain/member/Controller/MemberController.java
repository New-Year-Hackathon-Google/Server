package com.server.backyaserver.domain.member.Controller;

import com.server.backyaserver.domain.member.dto.response.MemberGetResponse;
import com.server.backyaserver.domain.member.entity.Member;
import com.server.backyaserver.domain.member.service.MemberService;
import com.server.backyaserver.global.annotation.AuthUser;
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
    public ResponseEntity<MemberGetResponse> memberInfo(
            @AuthUser Member member
            ) {
        return ResponseEntity.ok().body(MemberGetResponse.of(member));
    }
}
