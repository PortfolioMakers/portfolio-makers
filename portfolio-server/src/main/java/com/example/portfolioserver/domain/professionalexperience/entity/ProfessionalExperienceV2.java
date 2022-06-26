package com.example.portfolioserver.domain.professionalexperience.entity;

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
public class ProfessionalExperienceV2 extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolioV2_id")
    private PortfolioV2 portfolioV2;

    private String experience;

    private LocalDate periodFrom;
    private LocalDate periodTo;

    private String contents;

    @Builder
    public ProfessionalExperienceV2(Long id, PortfolioV2 portfolioV2, String experience, LocalDate periodFrom, LocalDate periodTo, String contents) {
        this.id = id;
        this.experience = experience;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.contents = contents;
    }

    public void setPortfolioV2(PortfolioV2 portfolioV2) {
        this.portfolioV2 = portfolioV2;
    }
}
