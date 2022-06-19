package com.example.portfolioserver.domain.career.dto;

import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
public class CareerDto {
    private Long id;
    @NotBlank(message = "{CareerDto.company.not.blank}")
    private String company;
    @NotBlank(message = "{CareerDto.duty.not.blank}")
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
