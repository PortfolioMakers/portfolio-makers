package com.example.portfolioserver.domain.skill.application;

import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.skill.dao.SkillRepository;
import com.example.portfolioserver.domain.skill.dto.SkillDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillRegisterServiceImpl implements SkillRegisterService {

    private final SkillRepository skillRepository;

    @Override
    public void Register(Portfolio portfolio, List<SkillDto> skillDtos) {
        skillDtos.forEach(skillDto -> skillRepository.save(skillDto.toEntity(portfolio)));
    }
}
