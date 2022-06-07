package com.example.portfolioserver.domain.portfolio.application;

import com.example.portfolioserver.domain.portfolio.dto.PortfolioDto;

public interface PortfolioRegisterService {
    Long Register(Long memberId, PortfolioDto portfolioDto);
}
