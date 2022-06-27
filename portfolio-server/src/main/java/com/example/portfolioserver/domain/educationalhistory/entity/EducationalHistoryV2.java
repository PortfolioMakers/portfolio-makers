package com.example.portfolioserver.domain.educationalhistory.entity;

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
public class EducationalHistoryV2 extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolioV2_id")
    private PortfolioV2 portfolioV2;

    private String school;

    private String majorType;
    private String majorDepartment;

    private LocalDate periodFrom;
    private LocalDate periodTo;

    @Builder
    public EducationalHistoryV2(Long id, String school, String majorType, String majorDepartment, LocalDate periodFrom, LocalDate periodTo) {
        this.id = id;
        this.school = school;
        this.majorType = majorType;
        this.majorDepartment = majorDepartment;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
    }

    public void setPortfolioV2(PortfolioV2 portfolioV2) {
        this.portfolioV2 = portfolioV2;
    }
}
