package com.example.portfolioserver.domain.portfolio.entity;

import com.example.portfolioserver.domain.base.entity.BaseTimeEntity;
import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Portfolio extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basic_info_id")
    private BasicInfo basicInfo;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("periodFrom asc")
    private List<EducationalHistory> educationalHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("periodFrom asc")
    private List<Career> careerList = new ArrayList<>();

    @Builder
    public Portfolio(Member member, BasicInfo basicInfo) {
        this.member = member;
        this.basicInfo = basicInfo;
    }

    public void addEducationalHistory(EducationalHistory educationalHistory) {
        educationalHistoryList.add(educationalHistory);
        educationalHistory.setPortfolio(this);
    }

    public void addCareer(Career career) {
        careerList.add(career);
        career.setPortfolio(this);
    }

    public static Portfolio createPortfolio(Member member, BasicInfo basicInfo, List<EducationalHistory> educationalHistoryList, List<Career> careerList) {
        Portfolio portfolio = Portfolio.builder()
                .basicInfo(basicInfo)
                .member(member)
                .build();
        for(EducationalHistory educationalHistory : educationalHistoryList) {
            portfolio.addEducationalHistory(educationalHistory);
        }
        for(Career career : careerList) {
            portfolio.addCareer(career);
        }
        return portfolio;
    }

    public void editPortfolio(BasicInfo basicInfo, List<EducationalHistory> educationalHistoryList, List<Career> careerList) {
        this.basicInfo = basicInfo;
        this.educationalHistoryList.clear();
        for(EducationalHistory educationalHistory : educationalHistoryList) {
            this.addEducationalHistory(educationalHistory);
        }
        this.careerList.clear();
        for(Career career : careerList) {
            this.addCareer(career);
        }
    }
}