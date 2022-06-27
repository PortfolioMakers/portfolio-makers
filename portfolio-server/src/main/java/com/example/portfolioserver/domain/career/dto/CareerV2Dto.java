package com.example.portfolioserver.domain.career.dto;

import com.example.portfolioserver.domain.career.entity.CareerV2;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CareerV2Dto {
    private Long id;
    @NotBlank(message = "{CareerDto.company.not.blank}")
    private String company;
    @NotBlank(message = "{CareerDto.duty.not.blank}")
    private String duty;
    private LocalDate periodFrom;
    private LocalDate periodTo;

    public CareerV2Dto(CareerV2 careerV2) {
        this.id = careerV2.getId();
        this.company = careerV2.getCompany();
        this.duty = careerV2.getDuty();
        this.periodFrom = careerV2.getPeriodFrom();
        this.periodTo = careerV2.getPeriodTo();
    }

    public CareerV2 toEntity() {
        return CareerV2.builder()
                .id(id)
                .company(company)
                .duty(duty)
                .periodFrom(periodFrom)
                .periodTo(periodTo)
                .build();
    }
}
