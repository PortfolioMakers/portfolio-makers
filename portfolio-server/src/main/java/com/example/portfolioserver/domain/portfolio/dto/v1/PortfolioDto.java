package com.example.portfolioserver.domain.portfolio.dto.v1;

import com.example.portfolioserver.domain.award.dto.AwardDto;
import com.example.portfolioserver.domain.basicinfo.dto.BasicInfoDto;
import com.example.portfolioserver.domain.career.dto.CareerDto;
import com.example.portfolioserver.domain.educationalhistory.dto.EducationalHistoryDto;
import com.example.portfolioserver.domain.professionalexperience.dto.ProfessionalExperienceDto;
import com.example.portfolioserver.domain.skill.dto.SkillDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
public class PortfolioDto {

    @Valid
    private BasicInfoDto basicInfoDto;
    @Valid
    private List<EducationalHistoryDto> educationalHistoryDtos;
    @Valid
    private List<CareerDto> careerDtos;
    @Valid
    private List<ProfessionalExperienceDto> professionalExperienceDtos;
    @Valid
    private List<AwardDto> awardDtos;
    @Valid
    private List<SkillDto> skillDtos;
}
