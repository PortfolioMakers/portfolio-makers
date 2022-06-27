package com.example.portfolioserver.domain.skill.application;

import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.skill.dto.SkillDto;

import java.util.List;

public interface SkillEditService {
    void Edit(Portfolio portfolio, List<SkillDto> skillDtos);
}
