package com.example.portfolioserver.domain.career.dto;

import com.example.portfolioserver.domain.career.entity.Career;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CareerSearchDto {
    private Long id;
    private String company;
    private String duty;
    private LocalDate periodFrom;
    private LocalDate periodTo;

    public CareerSearchDto(Career career) {
        this.id = career.getId();
        this.company = career.getCompany();
        this.duty = career.getDuty();
        this.periodFrom = career.getPeriodFrom();
        this.periodTo = career.getPeriodTo();
    }
}
