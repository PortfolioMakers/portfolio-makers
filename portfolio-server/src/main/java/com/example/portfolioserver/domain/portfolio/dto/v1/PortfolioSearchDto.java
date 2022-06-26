package com.example.portfolioserver.domain.portfolio.dto.v1;

import com.example.portfolioserver.domain.award.dto.AwardDto;
import com.example.portfolioserver.domain.award.entity.Award;
import com.example.portfolioserver.domain.basicinfo.dto.BasicInfoDto;
import com.example.portfolioserver.domain.career.dto.CareerDto;
import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.educationalhistory.dto.EducationalHistoryDto;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.professionalexperience.dto.ProfessionalExperienceDto;
import com.example.portfolioserver.domain.professionalexperience.entity.ProfessionalExperience;
import com.example.portfolioserver.domain.skill.dto.SkillDto;
import com.example.portfolioserver.domain.skill.entity.Skill;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PortfolioSearchDto {

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private BasicInfoDto basicInfoDto;
    private List<EducationalHistoryDto> educationalHistoryDtos;
    private List<CareerDto> careerDtos;
    private List<ProfessionalExperienceDto> professionalExperienceDtos;
    private List<AwardDto> awardDtos;
    private List<SkillDto> skillDtos;

    @Builder
    public PortfolioSearchDto(Portfolio portfolio, List<EducationalHistory> educationalHistories, List<Career> careers, List<ProfessionalExperience> professionalExperiences, List<Award> awards, List<Skill> skills) {
        this.createdDate = portfolio.getCreatedDate();
        this.lastModifiedDate = portfolio.getLastModifiedDate();
        this.basicInfoDto = new BasicInfoDto(portfolio.getBasicInfo());
        this.educationalHistoryDtos = educationalHistories.stream()
                .map(educationalHistory -> new EducationalHistoryDto(educationalHistory))
                .collect(Collectors.toList());
        this.careerDtos = careers.stream()
                .map(career -> new CareerDto(career))
                .collect(Collectors.toList());
        this.professionalExperienceDtos = professionalExperiences.stream()
                .map(professionalExperience -> new ProfessionalExperienceDto(professionalExperience))
                .collect(Collectors.toList());
        this.awardDtos = awards.stream()
                .map(award -> new AwardDto(award))
                .collect(Collectors.toList());

        this.skillDtos = skills.stream()
                .map(skill -> new SkillDto(skill))
                .collect(Collectors.toList());
    }
}
