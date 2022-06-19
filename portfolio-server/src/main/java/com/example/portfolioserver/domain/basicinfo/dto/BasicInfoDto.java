package com.example.portfolioserver.domain.basicinfo.dto;

import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class BasicInfoDto {

    private Long id;

    @NotBlank(message = "{BasicInfoDto.name.not.blank}")
    private String name;

    @NotBlank(message = "{BasicInfoDto.email.not.blank}")
    private String email;

    @NotBlank(message = "{BasicInfoDto.mobile.not.blank}")
    private String mobile;

    public BasicInfo getEntity() {
        return BasicInfo.builder()
                .id(id)
                .name(name)
                .email(email)
                .mobile(mobile)
                .build();
    }
}
