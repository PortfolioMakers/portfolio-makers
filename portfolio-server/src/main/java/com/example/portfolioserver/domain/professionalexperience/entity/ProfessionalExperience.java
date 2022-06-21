package com.example.portfolioserver.domain.professionalexperience.entity;

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
public class ProfessionalExperience extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    private String experience;

    private LocalDate periodFrom;
    private LocalDate periodTo;

    private String contents;

    @Builder
    public ProfessionalExperience(Long id, Portfolio portfolio, String experience, LocalDate periodFrom, LocalDate periodTo, String contents) {
        this.id = id;
        this.portfolio = portfolio;
        this.experience = experience;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.contents = contents;
    }
}
