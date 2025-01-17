package com.server.backyaserver.domain.member.Controller;

import com.server.backyaserver.domain.member.dto.response.MemberInfoResponse;
import com.server.backyaserver.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberInfoResponse> memberInfo() {
        return ResponseEntity.ok().body(null);
    }
}
