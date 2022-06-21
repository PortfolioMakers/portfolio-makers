package com.example.portfolioserver.domain.skill.application;

import com.example.portfolioserver.domain.educationalhistory.dao.EducationalHistoryRepository;
import com.example.portfolioserver.domain.educationalhistory.dto.EducationalHistoryDto;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.skill.dao.SkillRepository;
import com.example.portfolioserver.domain.skill.dto.SkillDto;
import com.example.portfolioserver.domain.skill.entity.Skill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillEditServiceImpl implements SkillEditService {

    private final SkillRepository skillRepository;

    @Override
    public void Edit(Portfolio portfolio, List<SkillDto> skillDtos) {
        List<Long> ids = skillDtos.stream().map(SkillDto::getId).filter(Objects::nonNull).collect(Collectors.toList());
        skillRepository.deleteIdsNotIn(portfolio, ids);
        List<Skill> skills = skillDtos.stream().map(skillDto -> skillDto.toEntity(portfolio)).collect(Collectors.toList());
        skillRepository.saveAll(skills);
    }
}
