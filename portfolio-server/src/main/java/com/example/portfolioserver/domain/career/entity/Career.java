package com.example.portfolioserver.domain.career.entity;

import com.example.portfolioserver.domain.base.entity.BaseTimeEntity;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class Career extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    private String company;

    private String duty;

    private LocalDate periodFrom;

    private LocalDate periodTo;

    @Builder
    public Career(Long id, String company, String duty, LocalDate periodFrom, LocalDate periodTo) {
        this.id = id;
        this.company = company;
        this.duty = duty;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
