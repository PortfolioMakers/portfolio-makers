package com.example.portfolioserver.domain.basicinfo.dto;

import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class BasicInfoDto {
    private Long id;
    @NotBlank(message = "Testsetest")
    private String name;
    private String email;
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
