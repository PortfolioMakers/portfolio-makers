package com.example.portfolioserver.domain.portfolio.application;

import com.example.portfolioserver.domain.portfolio.dao.PortfolioRepository;
import com.example.portfolioserver.domain.portfolio.dto.PortfolioSearchDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortfolioSearchServiceImpl implements PortfolioSearchService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioSearchDto Search(Long id) {
        Portfolio portfolio = portfolioRepository.Search(id).
                orElseThrow(() -> new IllegalArgumentException(""));
        return new PortfolioSearchDto(portfolio);
    }
}
