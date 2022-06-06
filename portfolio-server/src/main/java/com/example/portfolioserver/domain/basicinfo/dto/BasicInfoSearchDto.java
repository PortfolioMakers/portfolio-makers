package com.example.portfolioserver.domain.basicinfo.dto;

import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BasicInfoSearchDto {

    private String name;
    private String email;
    private String mobile;

    public BasicInfoSearchDto(BasicInfo basicInfo) {
        this.name = basicInfo.getName();
        this.email = basicInfo.getEmail();
        this.mobile = basicInfo.getMobile();
    }
}
