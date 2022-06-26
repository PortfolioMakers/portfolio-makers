package com.example.portfolioserver.domain.portfolio.dto.v2;

import com.example.portfolioserver.domain.award.dto.AwardV2Dto;
import com.example.portfolioserver.domain.basicinfo.dto.BasicInfoV2Dto;
import com.example.portfolioserver.domain.career.dto.CareerV2Dto;
import com.example.portfolioserver.domain.educationalhistory.dto.EducationalHistoryV2Dto;
import com.example.portfolioserver.domain.portfolio.entity.PortfolioV2;
import com.example.portfolioserver.domain.professionalexperience.dto.ProfessionalExperienceV2Dto;
import com.example.portfolioserver.domain.skill.dto.SkillV2Dto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PortfolioV2SearchDto {
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private BasicInfoV2Dto basicInfoV2Dto;
    private List<EducationalHistoryV2Dto> educationalHistoryV2Dtos;
    private List<CareerV2Dto> careerV2Dtos;
    private List<ProfessionalExperienceV2Dto> professionalExperienceV2Dtos;
    private List<AwardV2Dto> awardV2Dtos;
    private List<SkillV2Dto> skillV2Dtos;

    public PortfolioV2SearchDto(PortfolioV2 portfolioV2) {
        this.createdDate = portfolioV2.getCreatedDate();
        this.lastModifiedDate = portfolioV2.getLastModifiedDate();
        this.basicInfoV2Dto = new BasicInfoV2Dto(portfolioV2.getBasicInfoV2());
        this.educationalHistoryV2Dtos = portfolioV2.getEducationalHistoryV2s().stream()
                .map(educationalHistoryV2 -> new EducationalHistoryV2Dto(educationalHistoryV2))
                .collect(Collectors.toList());
        this.careerV2Dtos = portfolioV2.getCareerV2s().stream()
                .map(careerV2 -> new CareerV2Dto(careerV2))
                .collect(Collectors.toList());
        this.professionalExperienceV2Dtos = portfolioV2.getProfessionalExperienceV2s().stream()
                .map(professionalExperienceV2 -> new ProfessionalExperienceV2Dto(professionalExperienceV2))
                .collect(Collectors.toList());
        this.awardV2Dtos = portfolioV2.getAwardV2s().stream()
                .map(awardV2 -> new AwardV2Dto(awardV2))
                .collect(Collectors.toList());
        this.skillV2Dtos = portfolioV2.getSkillV2s().stream()
                .map(skillV2 -> new SkillV2Dto(skillV2))
                .collect(Collectors.toList());
    }
}
