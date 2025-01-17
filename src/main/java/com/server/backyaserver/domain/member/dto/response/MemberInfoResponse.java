package com.server.backyaserver.domain.member.dto.response;

import com.server.backyaserver.domain.member.entity.MemberRole;

public record MemberInfoResponse(
    String name,
    String email,
    MemberRole role
) {

}
