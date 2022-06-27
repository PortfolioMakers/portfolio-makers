package com.example.portfolioserver.domain.educationalhistory.dto;

import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistoryV2;
import com.example.portfolioserver.global.NotBlankIfContains;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NotBlankIfContains.List({
        @NotBlankIfContains(field = "school", fieldContains = "대학", targetField = "majorDepartment"),
        @NotBlankIfContains(field = "school", fieldContains = "대학", targetField = "majorType")
})
@Getter
@NoArgsConstructor
public class EducationalHistoryV2Dto {

    private Long id;
    @NotBlank(message = "{EducationalHistoryDto.school.not.blank}")
    private String school;
    private String majorType;
    private String majorDepartment;
    private LocalDate periodFrom;
    private LocalDate periodTo;

    public EducationalHistoryV2 toEntity() {
        return EducationalHistoryV2.builder()
                .id(id)
                .school(school)
                .majorType(majorType)
                .majorDepartment(majorDepartment)
                .periodFrom(periodFrom)
                .periodTo(periodTo)
                .build();
    }

    public EducationalHistoryV2Dto(EducationalHistoryV2 educationalHistoryV2) {
        this.id = educationalHistoryV2.getId();
        this.school = educationalHistoryV2.getSchool();
        this.majorType = educationalHistoryV2.getMajorType();
        this.majorDepartment = educationalHistoryV2.getMajorDepartment();
        this.periodFrom = educationalHistoryV2.getPeriodFrom();
        this.periodTo = educationalHistoryV2.getPeriodTo();
    }
}
