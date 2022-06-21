package com.example.portfolioserver.domain.professionalexperience.application;

import com.example.portfolioserver.domain.educationalhistory.dao.EducationalHistoryRepository;
import com.example.portfolioserver.domain.educationalhistory.dto.EducationalHistoryDto;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.professionalexperience.dao.ProfessionalExperienceRepository;
import com.example.portfolioserver.domain.professionalexperience.dto.ProfessionalExperienceDto;
import com.example.portfolioserver.domain.professionalexperience.entity.ProfessionalExperience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessionalExperienceEditServiceImpl implements ProfessionalExperienceEditService {

    private final ProfessionalExperienceRepository professionalExperienceRepository;

    @Override
    public void Edit(Portfolio portfolio, List<ProfessionalExperienceDto> professionalExperienceDtos) {
        List<Long> ids = professionalExperienceDtos.stream().map(ProfessionalExperienceDto::getId).filter(Objects::nonNull).collect(Collectors.toList());
        professionalExperienceRepository.deleteIdsNotIn(portfolio, ids);
        List<ProfessionalExperience> professionalExperiences = professionalExperienceDtos.stream()
                .map(professionalExperienceDto -> professionalExperienceDto.toEntity(portfolio))
                .collect(Collectors.toList());
        professionalExperienceRepository.saveAll(professionalExperiences);
    }
}
