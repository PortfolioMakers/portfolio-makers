package com.example.portfolioserver.domain.portfolio.application.v2;

import com.example.portfolioserver.domain.portfolio.dto.v2.PortfolioV2Dto;

public interface PortfolioV2EditService {
    Long Edit(Long id, PortfolioV2Dto portfolioV2Dto);
}
