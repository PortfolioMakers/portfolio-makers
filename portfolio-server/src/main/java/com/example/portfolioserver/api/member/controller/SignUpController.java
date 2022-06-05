package com.example.portfolioserver.api.member.controller;

import com.example.portfolioserver.api.member.dto.SignUpResponseDto;
import com.example.portfolioserver.api.member.dto.SignUpRequestDto;
import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SignUpController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody @Validated SignUpRequestDto dto, HttpServletRequest httpServletRequest){

        //TODO - entity 변환을 어디서 해야할지 고민
        Member member = dto.toEntity(passwordEncoder);
        Member saveMember = Member.createMember(member);
        var signUpResponseDto =  memberService.signUp(saveMember);
        return ResponseEntity.ok(signUpResponseDto);
    }
}
