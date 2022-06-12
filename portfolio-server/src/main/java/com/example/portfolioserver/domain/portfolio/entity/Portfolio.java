package com.example.portfolioserver.domain.portfolio.entity;

import com.example.portfolioserver.domain.base.entity.BaseTimeEntity;
import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import com.example.portfolioserver.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "basic_info_id")
    private BasicInfo basicInfo;

    private Portfolio(Member member, BasicInfo basicInfo) {
        this.member = member;
        this.basicInfo = basicInfo;
    }

    public static Portfolio create(Member member, BasicInfo basicInfo) {
        return new Portfolio(member, basicInfo);
    }
}