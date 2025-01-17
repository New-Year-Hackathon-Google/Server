package com.server.backyaserver.repository;

import com.server.backyaserver.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);
}