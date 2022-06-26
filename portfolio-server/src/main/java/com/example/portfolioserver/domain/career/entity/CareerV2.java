package com.example.portfolioserver.domain.career.entity;

import com.example.portfolioserver.domain.base.entity.BaseTimeEntity;
import com.example.portfolioserver.domain.portfolio.entity.PortfolioV2;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class CareerV2 extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolioV2_id")
    private PortfolioV2 portfolioV2;

    private String company;

    private String duty;

    private LocalDate periodFrom;

    private LocalDate periodTo;

    @Builder
    public CareerV2(Long id, String company, String duty, LocalDate periodFrom, LocalDate periodTo) {
        this.id = id;
        this.company = company;
        this.duty = duty;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
    }

    public void setPortfolioV2(PortfolioV2 portfolioV2) {
        this.portfolioV2 = portfolioV2;
    }
}
