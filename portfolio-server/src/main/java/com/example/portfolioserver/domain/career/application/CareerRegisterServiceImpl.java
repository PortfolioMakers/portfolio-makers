package com.example.portfolioserver.domain.career.application;

import com.example.portfolioserver.domain.career.dao.CareerRepository;
import com.example.portfolioserver.domain.career.dto.CareerDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CareerRegisterServiceImpl implements CareerRegisterService {

    private final CareerRepository careerRepository;

    public void Register(Portfolio portfolio, List<CareerDto> careerDtos) {
        careerDtos.forEach(careerDto -> careerRepository.save(careerDto.toEntity(portfolio)));
    }
}
