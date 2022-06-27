package com.example.portfolioserver.domain.professionalexperience.application;

import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.professionalexperience.dao.ProfessionalExperienceRepository;
import com.example.portfolioserver.domain.professionalexperience.dto.ProfessionalExperienceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionalExperienceRegisterServiceImpl implements ProfessionalExperienceRegisterService {

    private final ProfessionalExperienceRepository professionalExperienceRepository;

    @Override
    public void Register(Portfolio portfolio, List<ProfessionalExperienceDto> professionalExperienceDtos) {
        professionalExperienceDtos.forEach(professionalExperienceDto -> professionalExperienceRepository.save(professionalExperienceDto.toEntity(portfolio)));
    }
}
