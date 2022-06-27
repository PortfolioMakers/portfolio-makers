package com.example.portfolioserver.domain.portfolio.entity;


import com.example.portfolioserver.domain.award.entity.AwardV2;
import com.example.portfolioserver.domain.base.entity.BaseTimeEntity;
import com.example.portfolioserver.domain.basicinfo.entity.BasicInfoV2;
import com.example.portfolioserver.domain.career.entity.CareerV2;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistoryV2;
import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.professionalexperience.entity.ProfessionalExperienceV2;
import com.example.portfolioserver.domain.skill.entity.SkillV2;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class PortfolioV2 extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basic_infoV2_id")
    private BasicInfoV2 basicInfoV2;

    @OneToMany(mappedBy = "portfolioV2", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("periodFrom asc")
    private List<EducationalHistoryV2> educationalHistoryV2s = new ArrayList<>();

    @OneToMany(mappedBy = "portfolioV2", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("periodFrom asc")
    private List<CareerV2> careerV2s = new ArrayList<>();

    @OneToMany(mappedBy = "portfolioV2", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("periodFrom asc")
    private List<ProfessionalExperienceV2> professionalExperienceV2s = new ArrayList<>();

    @OneToMany(mappedBy = "portfolioV2", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("awardDate asc")
    private List<AwardV2> awardV2s = new ArrayList<>();

    @OneToMany(mappedBy = "portfolioV2", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SkillV2> skillV2s = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    private void addEducationalHistoryV2(EducationalHistoryV2 educationalHistoryV2) {
        educationalHistoryV2s.add(educationalHistoryV2);
        educationalHistoryV2.setPortfolioV2(this);
    }

    private void addCareerV2(CareerV2 careerV2) {
        careerV2s.add(careerV2);
        careerV2.setPortfolioV2(this);
    }

    private void addProfessionalExperienceV2(ProfessionalExperienceV2 professionalExperienceV2) {
        professionalExperienceV2s.add(professionalExperienceV2);
        professionalExperienceV2.setPortfolioV2(this);
    }

    private void addAwardV2(AwardV2 awardV2) {
        awardV2s.add(awardV2);
        awardV2.setPortfolioV2(this);
    }

    private void addSkillV2(SkillV2 skillV2) {
        skillV2s.add(skillV2);
        skillV2.setPortfolioV2(this);
    }

    @Builder
    public PortfolioV2(Long id, Member member, BasicInfoV2 basicInfoV2, List<EducationalHistoryV2> educationalHistoryV2s, List<CareerV2> careerV2s,
                       List<ProfessionalExperienceV2> professionalExperienceV2s, List<AwardV2> awardV2s, List<SkillV2> skillV2s) {
        this.id = id;
        this.basicInfoV2 = basicInfoV2;
        this.member = member;
        for(EducationalHistoryV2 educationalHistoryV2 : educationalHistoryV2s) {
            this.addEducationalHistoryV2(educationalHistoryV2);
        }
        for(CareerV2 careerV2 : careerV2s) {
            this.addCareerV2(careerV2);
        }
        for(ProfessionalExperienceV2 professionalExperienceV2 : professionalExperienceV2s) {
            this.addProfessionalExperienceV2(professionalExperienceV2);
        }
        for(AwardV2 awardV2 : awardV2s) {
            this.addAwardV2(awardV2);
        }
        for(SkillV2 skillV2 : skillV2s) {
            this.addSkillV2(skillV2);
        }
    }
}
