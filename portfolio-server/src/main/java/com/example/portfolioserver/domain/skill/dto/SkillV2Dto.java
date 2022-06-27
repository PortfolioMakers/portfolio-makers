package com.example.portfolioserver.domain.skill.dto;

import com.example.portfolioserver.domain.skill.entity.SkillV2;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SkillV2Dto {
    private Long id;

    private String name;
    private String contents;

    public SkillV2Dto(SkillV2 skillV2) {
        this.id = skillV2.getId();
        this.name = skillV2.getName();
        this.contents = skillV2.getContents();
    }
    public SkillV2 toEntity() {
        return SkillV2.builder()
                .id(id)
                .name(name)
                .contents(contents)
                .build();
    }
}
