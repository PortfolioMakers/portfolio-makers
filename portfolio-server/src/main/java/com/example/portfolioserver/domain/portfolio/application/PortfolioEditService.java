package com.example.portfolioserver.domain.portfolio.application;

import com.example.portfolioserver.domain.portfolio.dto.PortfolioDto;

public interface PortfolioEditService {
    Long Edit(Long id, PortfolioDto portfolioDto);
}
