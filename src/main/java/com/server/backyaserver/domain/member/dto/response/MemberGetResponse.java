package com.server.backyaserver.domain.member.dto.response;

import com.server.backyaserver.domain.member.domain.Member;

public record MemberGetResponse(
    Long id,
    String name,
    String email
) {

    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
            member.getId(),
            member.getName(),
            member.getEmail()
        );
    }
}
