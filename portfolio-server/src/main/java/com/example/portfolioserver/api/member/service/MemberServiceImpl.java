package com.example.portfolioserver.api.member.service;

import com.example.portfolioserver.api.member.dto.SignUpRequestDto;
import com.example.portfolioserver.api.member.dto.SignUpResponseDto;
import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.member.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements  MemberService {


    private final SignUpService signUpService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {

        Member member = signUpRequestDto.toEntity(passwordEncoder);
        Member saveMember = Member.createMember(member);
        signUpService.register(saveMember);

        return SignUpResponseDto.signUpResponseDto(saveMember.getEmail(), saveMember.getName());
    }
}
