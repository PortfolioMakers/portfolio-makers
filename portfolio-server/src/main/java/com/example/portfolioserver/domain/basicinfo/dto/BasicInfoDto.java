package com.example.portfolioserver.domain.basicinfo.dto;

import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class BasicInfoDto {

    private Long id;

    @NotBlank(message = "{BasicInfoDto.name.not.blank}")
    private String name;

    @NotBlank(message = "{BasicInfoDto.email.not.blank}")
    private String email;

    @NotBlank(message = "{BasicInfoDto.mobile.not.blank}")
    private String mobile;

    public BasicInfoDto(BasicInfo basicInfo) {
        this.id = basicInfo.getId();
        this.name = basicInfo.getName();
        this.email = basicInfo.getEmail();
        this.mobile = basicInfo.getMobile();
    }

    public BasicInfo toEntity() {
        return BasicInfo.builder()
                .id(id)
                .name(name)
                .email(email)
                .mobile(mobile)
                .build();
    }
}
