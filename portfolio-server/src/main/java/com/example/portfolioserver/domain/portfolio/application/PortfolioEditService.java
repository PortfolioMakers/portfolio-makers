package com.example.portfolioserver.domain.portfolio.application;

import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.portfolio.dao.PortfolioRepository;
import com.example.portfolioserver.domain.portfolio.dto.PortfolioDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioEditService {

    private final PortfolioRepository portfolioRepository;

    public Long Edit(Long id, PortfolioDto portfolioDto) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 포트폴리오가 없습니다."));
        BasicInfo basicInfo = portfolioDto.getBasicInfoDto().getEntity();
        List<EducationalHistory> educationalHistoryList = getEducationalHistoryList(portfolioDto);
        List<Career> careerList = getCareerList(portfolioDto);
        portfolio.editPortfolio(basicInfo, educationalHistoryList, careerList);
        return portfolioRepository.save(portfolio).getId();
    }

    private List<EducationalHistory> getEducationalHistoryList(PortfolioDto portfolioEdit) {
        return portfolioEdit.getEducationalHistoryDtos().stream()
                .map(educationalHistoryEdit -> educationalHistoryEdit.getEntity())
                .collect(Collectors.toList());
    }

    private List<Career> getCareerList(PortfolioDto portfolioDto) {
        return portfolioDto.getCareerDtos().stream()
                .map(careerDto -> careerDto.getEntity())
                .collect(Collectors.toList());
    }
}
