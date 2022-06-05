package com.example.portfolioserver.domain.member.service;

import com.example.portfolioserver.api.member.dto.SignUpResponseDto;
import com.example.portfolioserver.domain.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MemberService {
    SignUpResponseDto signUp(Member member);
    Optional<Member> findMemberByEmail(String email);
}
