package com.example.portfolioserver.domain.educationalhistory.dto;

import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class EducationalHistorySearchDto {

    private Long id;
    private String school;
    private String majorType;
    private String majorDepartment;
    private LocalDate periodFrom;
    private LocalDate periodTo;

    public EducationalHistorySearchDto(EducationalHistory educationalHistory) {
        this.id = educationalHistory.getId();
        this.school = educationalHistory.getSchool();
        this.majorType = educationalHistory.getMajorType();
        this.majorDepartment = educationalHistory.getMajorDepartment();
        this.periodFrom = educationalHistory.getPeriodFrom();
        this.periodTo = educationalHistory.getPeriodTo();
    }
}
