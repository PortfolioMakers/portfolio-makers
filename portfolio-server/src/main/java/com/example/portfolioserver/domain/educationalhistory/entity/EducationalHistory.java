package com.example.portfolioserver.domain.educationalhistory.entity;

import com.example.portfolioserver.domain.base.entity.BaseTimeEntity;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor
public class EducationalHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    private String school;

    private String majorType;
    private String majorDepartment;

    private LocalDate periodFrom;
    private LocalDate periodTo;

    @Builder
    public EducationalHistory(Long id, Portfolio portfolio, String school, String majorType, String majorDepartment, LocalDate periodFrom, LocalDate periodTo) {
        this.id = id;
        this.portfolio = portfolio;
        this.school = school;
        this.majorType = majorType;
        this.majorDepartment = majorDepartment;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}