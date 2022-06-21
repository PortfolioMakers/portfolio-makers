package com.example.portfolioserver.domain.award.entity;

import com.example.portfolioserver.domain.base.entity.BaseTimeEntity;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Award extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    private String name;

    private LocalDate awardDate;

    @Builder
    public Award(Long id, Portfolio portfolio, String name, LocalDate awardDate) {
        this.id = id;
        this.portfolio = portfolio;
        this.name = name;
        this.awardDate = awardDate;
    }
}
