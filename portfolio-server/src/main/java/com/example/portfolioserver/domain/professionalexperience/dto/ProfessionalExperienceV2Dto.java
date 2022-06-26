package com.example.portfolioserver.domain.professionalexperience.dto;

import com.example.portfolioserver.domain.professionalexperience.entity.ProfessionalExperienceV2;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ProfessionalExperienceV2Dto {
    private Long id;

    private String experience;

    private LocalDate periodFrom;
    private LocalDate periodTo;

    private String contents;

    public ProfessionalExperienceV2Dto(ProfessionalExperienceV2 professionalExperienceV2) {
        this.id = professionalExperienceV2.getId();
        this.experience = professionalExperienceV2.getExperience();
        this.periodFrom = professionalExperienceV2.getPeriodFrom();
        this.periodTo = professionalExperienceV2.getPeriodTo();
        this.contents = professionalExperienceV2.getContents();
    }

    public ProfessionalExperienceV2 toEntity() {
        return ProfessionalExperienceV2.builder()
                .id(id)
                .experience(experience)
                .periodFrom(periodFrom)
                .contents(contents)
                .periodTo(periodTo)
                .build();
    }
}
