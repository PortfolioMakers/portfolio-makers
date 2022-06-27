package com.example.portfolioserver.domain.portfolio.application.v2;

import com.example.portfolioserver.domain.portfolio.dto.v2.PortfolioV2Dto;

public interface PortfolioV2RegisterService {
    Long Register(Long memberId, PortfolioV2Dto portfolioDtoV2);
}
