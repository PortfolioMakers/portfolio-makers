package com.example.portfolioserver.domain.portfolio.application.v1;

import com.example.portfolioserver.domain.award.dao.AwardRepository;
import com.example.portfolioserver.domain.award.entity.Award;
import com.example.portfolioserver.domain.career.dao.CareerRepository;
import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.educationalhistory.dao.EducationalHistoryRepository;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.portfolio.dao.PortfolioRepository;
import com.example.portfolioserver.domain.portfolio.dto.v1.PortfolioSearchDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.professionalexperience.dao.ProfessionalExperienceRepository;
import com.example.portfolioserver.domain.professionalexperience.entity.ProfessionalExperience;
import com.example.portfolioserver.domain.skill.dao.SkillRepository;
import com.example.portfolioserver.domain.skill.entity.Skill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioSearchServiceImpl implements PortfolioSearchService {

    private final PortfolioRepository portfolioRepository;
    private final EducationalHistoryRepository educationalHistoryRepository;
    private final CareerRepository careerRepository;
    private final ProfessionalExperienceRepository professionalExperienceRepository;
    private final AwardRepository awardRepository;
    private final SkillRepository skillRepository;

    public PortfolioSearchDto Search(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException(""));
        List<EducationalHistory> educationalHistories = educationalHistoryRepository.findAllByPortfolio(portfolio);
        List<Career> careers = careerRepository.findAllByPortfolio(portfolio);
        List<ProfessionalExperience> professionalExperiences = professionalExperienceRepository.findAllByPortfolio(portfolio);
        List<Award> awards = awardRepository.findAllByPortfolio(portfolio);
        List<Skill> skills = skillRepository.findAllByPortfolio(portfolio);

        return PortfolioSearchDto.builder()
                .portfolio(portfolio)
                .educationalHistories(educationalHistories)
                .careers(careers)
                .professionalExperiences(professionalExperiences)
                .awards(awards)
                .skills(skills)
                .build();
    }
}
