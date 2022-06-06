package com.example.portfolioserver.domain.member.dao;

import com.example.portfolioserver.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
