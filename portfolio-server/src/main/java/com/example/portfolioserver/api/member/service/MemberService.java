package com.example.portfolioserver.api.member.service;

import com.example.portfolioserver.api.member.dto.SignUpRequestDto;
import com.example.portfolioserver.api.member.dto.SignUpResponseDto;

public interface MemberService {

    SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto);

}
