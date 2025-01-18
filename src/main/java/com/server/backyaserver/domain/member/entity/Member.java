package com.server.backyaserver.domain.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Builder
    public Member(String name, MemberRole role, String email) {
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public static Member createDefaultMember(String name, MemberRole role, String email) {
        return Member.builder()
                .name(name)
                .role(role)
                .email(email)
                .build();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}