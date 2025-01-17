package com.server.backyaserver.global.security.service;

import com.server.backyaserver.dto.CustomOAuth2User;
import com.server.backyaserver.dto.GoogleResponse;
import com.server.backyaserver.dto.OAuth2Response;

import com.server.backyaserver.dto.MemberDto;
import com.server.backyaserver.domain.member.entity.Member;
import com.server.backyaserver.repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

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
        Member existData = userRepository.findByUsername(username);

        if (existData == null) {

            Member member = new Member();
            member.setUsername(username);
            member.setEmail(oAuth2Response.getEmail());
            member.setName(oAuth2Response.getName());
            member.setRole("ROLE_USER");

            userRepository.save(member);

            MemberDto memberDto = new MemberDto();
            memberDto.setUsername(username);
            memberDto.setName(oAuth2Response.getName());
            memberDto.setRole("ROLE_USER");

            return new CustomOAuth2User(memberDto);
        }
        else {

            existData.setEmail(oAuth2Response.getEmail());
            existData.setName(oAuth2Response.getName());

            userRepository.save(existData);

            MemberDto memberDto = new MemberDto();
            memberDto.setUsername(existData.getUsername());
            memberDto.setName(oAuth2Response.getName());
            memberDto.setRole(existData.getRole());

            return new CustomOAuth2User(memberDto);
        }
    }
}