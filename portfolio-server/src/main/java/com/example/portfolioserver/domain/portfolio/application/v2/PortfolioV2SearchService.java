package com.example.portfolioserver.domain.portfolio.application.v2;

import com.example.portfolioserver.domain.portfolio.dto.v2.PortfolioV2SearchDto;

public interface PortfolioV2SearchService {
    PortfolioV2SearchDto Search(Long id);
}
