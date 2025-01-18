package com.server.backyaserver.domain.member.service;

import com.server.backyaserver.domain.member.entity.Member;
import com.server.backyaserver.domain.member.entity.MemberRole;
import com.server.backyaserver.domain.member.repository.MemberRepository;
import com.server.backyaserver.dto.OAuth2Response;
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

    @Transactional(readOnly = true)
    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmailOrThrow(email);
    }

    @Transactional
    public Member createMemberByOAuthInfo(OAuth2Response oauthInfo) {
        if(memberRepository.existsByEmail(oauthInfo.getEmail())) {
            return getMemberByEmail(oauthInfo.getEmail());
        }

        Member member = Member.createDefaultMember(oauthInfo.getName(), MemberRole.USER,
                oauthInfo.getEmail());

        return memberRepository.save(member);
    }

    @Transactional
    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }
}
