package com.example.portfolioserver.domain.portfolio.application;

import com.example.portfolioserver.domain.portfolio.dto.PortfolioSearchDto;

public interface PortfolioSearchService {
    PortfolioSearchDto Search(Long id);
}
