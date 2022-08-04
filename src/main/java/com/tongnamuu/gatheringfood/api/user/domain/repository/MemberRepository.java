package com.tongnamuu.gatheringfood.api.user.domain.repository;

import com.tongnamuu.gatheringfood.api.user.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
}
