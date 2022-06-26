package com.example.portfolioserver.domain.portfolio.application.v2;

import com.example.portfolioserver.domain.portfolio.dao.PortfolioV2Repository;
import com.example.portfolioserver.domain.portfolio.dto.v2.PortfolioV2SearchDto;
import com.example.portfolioserver.domain.portfolio.entity.PortfolioV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortfolioV2SearchServiceImpl implements PortfolioV2SearchService {

    private final PortfolioV2Repository portfolioV2Repository;

    @Override
    public PortfolioV2SearchDto Search(Long id) {
        PortfolioV2 portfolioV2 = portfolioV2Repository.Search(id).
                orElseThrow(() -> new IllegalArgumentException(""));
        return new PortfolioV2SearchDto(portfolioV2);
    }
}
