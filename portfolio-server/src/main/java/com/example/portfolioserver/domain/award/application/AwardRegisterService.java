package com.example.portfolioserver.domain.award.application;

import com.example.portfolioserver.domain.award.dto.AwardDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;

import java.util.List;

public interface AwardRegisterService {
    void Register(Portfolio portfolio, List<AwardDto> awardDtos);
}
