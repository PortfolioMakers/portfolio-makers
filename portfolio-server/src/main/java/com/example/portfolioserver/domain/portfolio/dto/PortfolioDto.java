package com.example.portfolioserver.domain.portfolio.dto;

import com.example.portfolioserver.domain.basicinfo.dto.BasicInfoDto;
import com.example.portfolioserver.domain.career.dto.CareerDto;
import com.example.portfolioserver.domain.educationalhistory.dto.EducationalHistoryDto;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class PortfolioDto {

    @NotNull
    @Valid
    private BasicInfoDto basicInfoDto;
    private List<EducationalHistoryDto> educationalHistoryDtos;
    private List<CareerDto> careerDtos;
}
