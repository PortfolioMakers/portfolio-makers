package com.example.portfolioserver.domain.career.dto;

import com.example.portfolioserver.domain.career.entity.Career;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CareerDto {
    private Long id;
    private String company;
    private String duty;
    private LocalDate periodFrom;
    private LocalDate periodTo;

    public Career getEntity() {
        return Career.builder()
                .id(id)
                .company(company)
                .duty(duty)
                .periodFrom(periodFrom)
                .periodTo(periodTo)
                .build();
    }
}
