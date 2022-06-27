package com.example.portfolioserver.domain.professionalexperience.application;

import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.professionalexperience.dto.ProfessionalExperienceDto;

import java.util.List;

public interface ProfessionalExperienceEditService {
    void Edit(Portfolio portfolio, List<ProfessionalExperienceDto> professionalExperienceDtos);
}
