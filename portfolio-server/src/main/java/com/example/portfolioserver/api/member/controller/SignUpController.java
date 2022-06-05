package com.example.portfolioserver.api.member.controller;

import com.example.portfolioserver.api.member.dto.SignUpResponseDto;
import com.example.portfolioserver.api.member.dto.SignUpRequestDto;
import com.example.portfolioserver.api.member.service.MemberService;
import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.member.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SignUpController {

    private final MemberService memberService;

    @PostMapping(value = "/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody @Validated SignUpRequestDto signUpRequestDto, HttpServletRequest httpServletRequest){
        var signUpResponseDto =  memberService.signUp(signUpRequestDto);
        return ResponseEntity.ok(signUpResponseDto);
    }
}
