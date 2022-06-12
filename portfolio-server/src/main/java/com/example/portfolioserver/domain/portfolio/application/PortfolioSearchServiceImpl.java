package com.example.portfolioserver.domain.portfolio.application;

import com.example.portfolioserver.domain.career.dao.CareerRepository;
import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.educationalhistory.dao.EducationalHistoryRepository;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.portfolio.dao.PortfolioRepository;
import com.example.portfolioserver.domain.portfolio.dto.PortfolioSearchDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioSearchServiceImpl implements PortfolioSearchService {

    private final PortfolioRepository portfolioRepository;
    private final EducationalHistoryRepository educationalHistoryRepository;
    private final CareerRepository careerRepository;

    public PortfolioSearchDto Search(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException(""));
        List<EducationalHistory> educationalHistories = educationalHistoryRepository.findAllByPortfolio(portfolio);
        List<Career> careers = careerRepository.findAllByPortfolio(portfolio);
        return new PortfolioSearchDto(portfolio, educationalHistories, careers);
    }
}
