package com.example.portfolioserver.domain.career.application;

import com.example.portfolioserver.domain.career.dto.CareerDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;

import java.util.List;

public interface CareerRegisterService {
    void Register(Portfolio portfolio, List<CareerDto> careerDtos);
}
