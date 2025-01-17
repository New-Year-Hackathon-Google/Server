package com.server.backyaserver.domain.member.service;

import com.server.backyaserver.domain.member.entity.Member;
import com.server.backyaserver.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

//    private Member createMember(String name, String role) {
//
//        Member member = Member.createDefaultMember(nickname, oauthInfo);
//        return memberRepository.save(member);
//    }
}
