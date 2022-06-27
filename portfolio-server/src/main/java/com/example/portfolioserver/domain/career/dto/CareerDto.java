package com.example.portfolioserver.domain.career.dto;

import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CareerDto {
    private Long id;
    @NotBlank(message = "{CareerDto.company.not.blank}")
    private String company;
    @NotBlank(message = "{CareerDto.duty.not.blank}")
    private String duty;
    private LocalDate periodFrom;
    private LocalDate periodTo;

    public CareerDto(Career career) {
        this.id = career.getId();
        this.company = career.getCompany();
        this.duty = career.getDuty();
        this.periodFrom = career.getPeriodFrom();
        this.periodTo = career.getPeriodTo();
    }

    public Career toEntity(Portfolio portfolio) {
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
