package com.example.portfolioserver.domain.educationalhistory.dto;

import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.portfolio.dto.NotBlankIfContains;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
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
public class EducationalHistoryDto {

    private Long id;
    @NotBlank(message = "{EducationalHistoryDto.school.not.blank}")
    private String school;
    private String majorType;
    private String majorDepartment;
    private LocalDate periodFrom;
    private LocalDate periodTo;

    public EducationalHistory toEntity(Portfolio portfolio) {
        return EducationalHistory.builder()
                .id(id)
                .portfolio(portfolio)
                .school(school)
                .majorType(majorType)
                .majorDepartment(majorDepartment)
                .periodFrom(periodFrom)
                .periodTo(periodTo)
                .build();
    }

    public EducationalHistoryDto(EducationalHistory educationalHistory) {
        this.id = educationalHistory.getId();
        this.school = educationalHistory.getSchool();
        this.majorType = educationalHistory.getMajorType();
        this.majorDepartment = educationalHistory.getMajorDepartment();
        this.periodFrom = educationalHistory.getPeriodFrom();
        this.periodTo = educationalHistory.getPeriodTo();
    }
}
