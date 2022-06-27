package com.example.portfolioserver.domain.award.dto;

import com.example.portfolioserver.domain.award.entity.AwardV2;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class AwardV2Dto {
    private Long id;
    private String name;
    private LocalDate awardDate;

    public AwardV2Dto(AwardV2 awardV2) {
        this.id = awardV2.getId();
        this.name = awardV2.getName();
        this.awardDate = awardV2.getAwardDate();
    }

    public AwardV2 toEntity() {
        return AwardV2.builder()
                .id(id)
                .name(name)
                .awardDate(awardDate)
                .build();
    }
}
