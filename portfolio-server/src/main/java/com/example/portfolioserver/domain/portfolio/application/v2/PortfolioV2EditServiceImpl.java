package com.example.portfolioserver.domain.portfolio.application.v2;

import com.example.portfolioserver.domain.portfolio.dao.PortfolioV2Repository;
import com.example.portfolioserver.domain.portfolio.dto.v2.PortfolioV2Dto;
import com.example.portfolioserver.domain.portfolio.entity.PortfolioV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PortfolioV2EditServiceImpl implements PortfolioV2EditService {

    private final PortfolioV2Repository portfolioV2Repository;

    @Override
    @Transactional
    public Long Edit(Long id, PortfolioV2Dto portfolioV2Dto) {
        PortfolioV2 portfolioV2 = portfolioV2Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 포트폴리오가 없습니다."));
        PortfolioV2 portfolioV2Edit = portfolioV2Dto.toEntity(portfolioV2.getMember());
        portfolioV2Edit.setId(id);
        return portfolioV2Repository.save(portfolioV2Edit).getId();
    }
}
