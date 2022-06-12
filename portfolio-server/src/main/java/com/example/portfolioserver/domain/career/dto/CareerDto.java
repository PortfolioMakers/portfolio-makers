package com.example.portfolioserver.domain.career.dto;

import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CareerDto {
    private Long id;
    private String company;
    private String duty;
    private LocalDate periodFrom;
    private LocalDate periodTo;

    public Career getEntity(Portfolio portfolio) {
        return Career.builder()
                .id(id)
                .company(company)
                .duty(duty)
                .periodFrom(periodFrom)
                .periodTo(periodTo)
                .portfolio(portfolio)
                .build();
    }
}
