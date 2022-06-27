package com.example.portfolioserver.domain.award.dto;

import com.example.portfolioserver.domain.award.entity.Award;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class AwardDto {
    private Long id;
    private String name;
    private LocalDate awardDate;

    public AwardDto(Award award) {
        this.id = award.getId();
        this.name = award.getName();
        this.awardDate = award.getAwardDate();
    }

    public Award toEntity(Portfolio portfolio) {
        return Award.builder()
                .id(id)
                .portfolio(portfolio)
                .name(name)
                .awardDate(awardDate)
                .build();
    }
}
