package com.example.portfolioserver.domain.career.application;

import com.example.portfolioserver.domain.career.dto.CareerDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;

import java.util.List;

public interface CareerEditService {
    void Edit(Portfolio portfolio, List<CareerDto> careerDtos);
}
