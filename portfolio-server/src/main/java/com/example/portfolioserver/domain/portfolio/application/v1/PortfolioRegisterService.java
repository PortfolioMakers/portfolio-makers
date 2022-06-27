package com.example.portfolioserver.domain.portfolio.application.v1;

import com.example.portfolioserver.domain.portfolio.dto.v1.PortfolioDto;

public interface PortfolioRegisterService {
    Long Register(Long memberId, PortfolioDto portfolioDto);
}
