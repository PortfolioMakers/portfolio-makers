package com.example.portfolioserver.domain.skill.entity;

import com.example.portfolioserver.domain.base.entity.BaseTimeEntity;
import com.example.portfolioserver.domain.portfolio.entity.PortfolioV2;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class SkillV2 extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contents;

    @ManyToOne
    @JoinColumn(name = "portfolioV2_id")
    private PortfolioV2 portfolioV2;

    @Builder
    public SkillV2(Long id, String name, String contents) {
        this.id = id;
        this.name = name;
        this.contents = contents;
    }

    public void setPortfolioV2(PortfolioV2 portfolioV2) {
        this.portfolioV2 = portfolioV2;
    }
}
