package com.example.portfolioserver.domain.portfolio.dto;

import com.example.portfolioserver.domain.basicinfo.dto.BasicInfoSearchDto;
import com.example.portfolioserver.domain.career.dto.CareerSearchDto;
import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.educationalhistory.dto.EducationalHistorySearchDto;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PortfolioSearchDto {

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private BasicInfoSearchDto basicInfoSearchDto;
    private List<EducationalHistorySearchDto> educationalHistorySearchDtos;
    private List<CareerSearchDto> careerSearchDtos;

    public PortfolioSearchDto(Portfolio portfolio, List<EducationalHistory> educationalHistories, List<Career> careers) {
        this.createdDate = portfolio.getCreatedDate();
        this.lastModifiedDate = portfolio.getLastModifiedDate();
        this.basicInfoSearchDto = new BasicInfoSearchDto(portfolio.getBasicInfo());
        this.educationalHistorySearchDtos = educationalHistories.stream()
                .map(educationalHistory -> new EducationalHistorySearchDto(educationalHistory))
                .collect(Collectors.toList());
        this.careerSearchDtos = careers.stream()
                .map(career -> new CareerSearchDto(career))
                .collect(Collectors.toList());
    }
}
