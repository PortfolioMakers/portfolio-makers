package com.example.portfolioserver.domain.portfolio.application;

import com.example.portfolioserver.domain.award.application.AwardEditService;
import com.example.portfolioserver.domain.basicinfo.dto.BasicInfoDto;
import com.example.portfolioserver.domain.career.application.CareerEditService;
import com.example.portfolioserver.domain.educationalhistory.application.EducationalHistoryEditService;
import com.example.portfolioserver.domain.portfolio.dao.PortfolioRepository;
import com.example.portfolioserver.domain.portfolio.dto.PortfolioDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.professionalexperience.application.ProfessionalExperienceEditService;
import com.example.portfolioserver.domain.skill.application.SkillEditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PortfolioEditServiceImpl implements PortfolioEditService {

    private final PortfolioRepository portfolioRepository;
    private final EducationalHistoryEditService educationalHistoryEditService;
    private final CareerEditService careerEditService;
    private final ProfessionalExperienceEditService professionalExperienceEditService;
    private final AwardEditService awardEditService;
    private final SkillEditService skillEditService;

    @Transactional
    public Long Edit(Long id, PortfolioDto portfolioDto) {
        Portfolio portfolio = editBasicInfo(id, portfolioDto);
        educationalHistoryEditService.Edit(portfolio, portfolioDto.getEducationalHistoryDtos());
        careerEditService.Edit(portfolio, portfolioDto.getCareerDtos());
        professionalExperienceEditService.Edit(portfolio, portfolioDto.getProfessionalExperienceDtos());
        awardEditService.Edit(portfolio, portfolioDto.getAwardDtos());
        skillEditService.Edit(portfolio, portfolioDto.getSkillDtos());
        return portfolio.getId();
    }

    private Portfolio editBasicInfo(Long id, PortfolioDto portfolioDto) {
        Portfolio portfolio = getPortfolio(id);
        BasicInfoDto basicInfoDto = portfolioDto.getBasicInfoDto();
        portfolio.getBasicInfo().edit(basicInfoDto.getEmail(), basicInfoDto.getMobile(), basicInfoDto.getName());
        return portfolioRepository.save(portfolio);
    }

    private Portfolio getPortfolio(Long id) {
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 포트폴리오가 없습니다."));
    }
}
