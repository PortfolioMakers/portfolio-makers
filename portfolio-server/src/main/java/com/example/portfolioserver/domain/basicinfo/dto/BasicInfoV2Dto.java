package com.example.portfolioserver.domain.basicinfo.dto;

import com.example.portfolioserver.domain.basicinfo.entity.BasicInfoV2;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class BasicInfoV2Dto {
    private Long id;

    @NotBlank(message = "{BasicInfoDto.name.not.blank}")
    private String name;

    @NotBlank(message = "{BasicInfoDto.email.not.blank}")
    private String email;

    @NotBlank(message = "{BasicInfoDto.mobile.not.blank}")
    private String mobile;

    public BasicInfoV2Dto(BasicInfoV2 basicInfoV2) {
        this.id = basicInfoV2.getId();
        this.name = basicInfoV2.getName();
        this.email = basicInfoV2.getEmail();
        this.mobile = basicInfoV2.getMobile();
    }

    public BasicInfoV2 toEntity() {
        return BasicInfoV2.builder()
                .id(id)
                .name(name)
                .email(email)
                .mobile(mobile)
                .build();
    }
}
