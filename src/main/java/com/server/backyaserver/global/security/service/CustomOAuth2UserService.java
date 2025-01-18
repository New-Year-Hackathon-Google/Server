package com.server.backyaserver.global.security.service;

import com.server.backyaserver.domain.member.entity.MemberRole;
import com.server.backyaserver.domain.member.repository.MemberRepository;
import com.server.backyaserver.domain.member.service.MemberService;
import com.server.backyaserver.dto.CustomOAuth2User;
import com.server.backyaserver.dto.GoogleResponse;
import com.server.backyaserver.dto.OAuth2Response;

import com.server.backyaserver.dto.MemberDto;
import com.server.backyaserver.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberService memberService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;

        if (registrationId.equals("google")) {

            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        } else {

            return null;
        }

        Member member = memberService.createMemberByOAuthInfo(oAuth2Response);

        MemberDto memberDto = new MemberDto();
        memberDto.setUsername(member.getId().toString());
        memberDto.setName(oAuth2Response.getName());
        memberDto.setRole(MemberRole.USER.getValue());

        return new CustomOAuth2User(memberDto);

    }
}