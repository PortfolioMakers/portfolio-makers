package com.example.portfolioserver.domain.portfolio.application.v1;

import com.example.portfolioserver.domain.portfolio.dto.v1.PortfolioSearchDto;

public interface PortfolioSearchService {
    PortfolioSearchDto Search(Long id);
}
