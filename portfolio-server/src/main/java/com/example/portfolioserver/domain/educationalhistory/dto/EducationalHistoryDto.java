package com.example.portfolioserver.domain.educationalhistory.dto;

import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EducationalHistoryDto {
    private Long id;
    private String school;
    private String majorType;
    private String majorDepartment;
    private LocalDate periodFrom;
    private LocalDate periodTo;

    public EducationalHistory getEntity() {
        return EducationalHistory.builder()
                .id(id)
                .school(school)
                .majorType(majorType)
                .majorDepartment(majorDepartment)
                .periodFrom(periodFrom)
                .periodTo(periodTo)
                .build();
    }
}
