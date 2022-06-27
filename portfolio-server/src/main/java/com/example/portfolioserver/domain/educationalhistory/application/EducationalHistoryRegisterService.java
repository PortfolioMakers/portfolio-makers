package com.example.portfolioserver.domain.educationalhistory.application;

import com.example.portfolioserver.domain.educationalhistory.dto.EducationalHistoryDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;

import java.util.List;

public interface EducationalHistoryRegisterService {
    void Register(Portfolio portfolio, List<EducationalHistoryDto> educationalHistoryDtos);
}
