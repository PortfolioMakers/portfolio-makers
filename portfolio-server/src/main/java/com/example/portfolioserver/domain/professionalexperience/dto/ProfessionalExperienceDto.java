package com.example.portfolioserver.domain.professionalexperience.dto;

import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.professionalexperience.entity.ProfessionalExperience;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ProfessionalExperienceDto {
    private Long id;

    private String experience;

    private LocalDate periodFrom;
    private LocalDate periodTo;

    private String contents;

    public ProfessionalExperienceDto(ProfessionalExperience professionalExperience) {
        this.id = professionalExperience.getId();
        this.experience = professionalExperience.getExperience();
        this.periodFrom = professionalExperience.getPeriodFrom();
        this.periodTo = professionalExperience.getPeriodTo();
        this.contents = professionalExperience.getContents();
    }

    public ProfessionalExperience toEntity(Portfolio portfolio) {
        return ProfessionalExperience.builder()
                .id(id)
                .portfolio(portfolio)
                .experience(experience)
                .periodFrom(periodFrom)
                .contents(contents)
                .periodTo(periodTo)
                .build();
    }
}
