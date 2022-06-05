package com.example.portfolioserver.api.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SignUpResponseDto {
    private String name;
    private String email;

    public static SignUpResponseDto signUpResponseDto(String email, String name){
        return SignUpResponseDto.builder()
                .email(email)
                .name(name)
                .build();
    }
}
