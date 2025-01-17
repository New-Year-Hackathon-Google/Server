package com.server.backyaserver.global.security.service;

import com.server.backyaserver.domain.member.entity.MemberRole;
import com.server.backyaserver.domain.member.repository.MemberRepository;
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

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;

        if (registrationId.equals("google")) {

            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }
        else {

            return null;
        }
        String username = oAuth2Response.getProvider()+" "+oAuth2Response.getProviderId();
        Member existData = memberRepository.findByUsername(username);

        if (existData == null) {

            Member member = Member.createDefaultMember(oAuth2Response.getName(), MemberRole.USER,
                    oAuth2Response.getEmail(), username);

            memberRepository.save(member);

            MemberDto memberDto = new MemberDto();
            memberDto.setUsername(member.getId().toString());
            memberDto.setName(oAuth2Response.getName());
            memberDto.setRole("ROLE_USER");

            return new CustomOAuth2User(memberDto);
        }
        else {

            existData.setEmail(oAuth2Response.getEmail());
            existData.setName(oAuth2Response.getName());

            memberRepository.save(existData);

            MemberDto memberDto = new MemberDto();
            memberDto.setName(oAuth2Response.getName());
            memberDto.setUsername(existData.getId().toString());

            memberDto.setRole(existData.getRole().getValue());

            return new CustomOAuth2User(memberDto);
        }
    }
}