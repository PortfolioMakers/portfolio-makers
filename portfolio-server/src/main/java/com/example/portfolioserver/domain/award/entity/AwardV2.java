package com.example.portfolioserver.domain.award.entity;

import com.example.portfolioserver.domain.base.entity.BaseTimeEntity;
import com.example.portfolioserver.domain.portfolio.entity.PortfolioV2;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class AwardV2 extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolioV2_id")
    private PortfolioV2 portfolioV2;

    private String name;

    private LocalDate awardDate;

    @Builder
    public AwardV2(Long id, String name, LocalDate awardDate) {
        this.id = id;
        this.name = name;
        this.awardDate = awardDate;
    }

    public void setPortfolioV2(PortfolioV2 portfolioV2) {
        this.portfolioV2 = portfolioV2;
    }
}
