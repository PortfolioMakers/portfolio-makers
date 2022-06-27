package com.example.portfolioserver.domain.career.application;

import com.example.portfolioserver.domain.career.dao.CareerRepository;
import com.example.portfolioserver.domain.career.dto.CareerDto;
import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CareerEditServiceImpl implements CareerEditService {

    private final CareerRepository careerRepository;

    public void Edit(Portfolio portfolio, List<CareerDto> careerDtos) {
        List<Long> ids = careerDtos.stream().map(CareerDto::getId).filter(Objects::nonNull).collect(Collectors.toList());
        careerRepository.deleteIdsNotIn(portfolio, ids);
        List<Career> careers = careerDtos.stream().map(careerDto -> careerDto.toEntity(portfolio)).collect(Collectors.toList());
        careerRepository.saveAll(careers);
    }
}
