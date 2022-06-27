package com.example.portfolioserver.domain.skill.dto;

import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.skill.entity.Skill;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SkillDto {
    private Long id;

    private String name;
    private String contents;

    public SkillDto(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.contents = skill.getContents();
    }

    public Skill toEntity(Portfolio portfolio) {
        return Skill.builder()
                .id(id)
                .portfolio(portfolio)
                .name(name)
                .contents(contents)
                .build();
    }
}
