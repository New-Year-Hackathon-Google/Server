package com.server.backyaserver.domain.member.repository;

import com.server.backyaserver.domain.member.domain.Member;
import com.server.backyaserver.global.error.exception.ErrorCode;
import com.server.backyaserver.global.error.exception.NotFoundException;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);
}
