package com.example.portfolioserver.domain.portfolio.dto.v2;

import com.example.portfolioserver.domain.award.dto.AwardV2Dto;
import com.example.portfolioserver.domain.award.entity.AwardV2;
import com.example.portfolioserver.domain.basicinfo.dto.BasicInfoV2Dto;
import com.example.portfolioserver.domain.career.dto.CareerV2Dto;
import com.example.portfolioserver.domain.career.entity.CareerV2;
import com.example.portfolioserver.domain.educationalhistory.dto.EducationalHistoryV2Dto;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistoryV2;
import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.portfolio.entity.PortfolioV2;
import com.example.portfolioserver.domain.professionalexperience.dto.ProfessionalExperienceV2Dto;
import com.example.portfolioserver.domain.professionalexperience.entity.ProfessionalExperienceV2;
import com.example.portfolioserver.domain.skill.dto.SkillV2Dto;
import com.example.portfolioserver.domain.skill.entity.SkillV2;
import lombok.Getter;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PortfolioV2Dto {
    @Valid
    private BasicInfoV2Dto basicInfoV2Dto;
    @Valid
    private List<EducationalHistoryV2Dto> educationalHistoryV2Dtos;
    @Valid
    private List<CareerV2Dto> careerV2Dtos;
    @Valid
    private List<ProfessionalExperienceV2Dto> professionalExperienceV2Dtos;
    @Valid
    private List<AwardV2Dto> awardV2Dtos;
    @Valid
    private List<SkillV2Dto> skillV2Dtos;

    public PortfolioV2 toEntity(Member member) {
        return PortfolioV2.builder()
                .member(member)
                .basicInfoV2(basicInfoV2Dto.toEntity())
                .educationalHistoryV2s(toEducationalHistoryV2s())
                .careerV2s(toCareerV2s())
                .professionalExperienceV2s(toProfessionalExperienceV2s())
                .awardV2s(toAwardV2s())
                .skillV2s(toSkillV2s())
                .build();
    }

    private List<EducationalHistoryV2> toEducationalHistoryV2s() {
        return this.educationalHistoryV2Dtos.stream()
                .map(EducationalHistoryV2Dto::toEntity)
                .collect(Collectors.toList());
    }

    private List<CareerV2> toCareerV2s() {
        return this.careerV2Dtos.stream()
                .map(CareerV2Dto::toEntity)
                .collect(Collectors.toList());
    }

    private List<ProfessionalExperienceV2> toProfessionalExperienceV2s() {
        return this.professionalExperienceV2Dtos.stream()
                .map(ProfessionalExperienceV2Dto::toEntity)
                .collect(Collectors.toList());
    }

    private List<AwardV2> toAwardV2s() {
        return this.awardV2Dtos.stream()
                .map(AwardV2Dto::toEntity)
                .collect(Collectors.toList());
    }

    private List<SkillV2> toSkillV2s() {
        return this.skillV2Dtos.stream()
                .map(SkillV2Dto::toEntity)
                .collect(Collectors.toList());
    }
}
