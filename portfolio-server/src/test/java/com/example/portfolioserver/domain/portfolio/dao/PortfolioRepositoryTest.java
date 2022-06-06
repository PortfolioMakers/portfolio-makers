package com.example.portfolioserver.domain.portfolio.dao;

import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@SpringBootTest
@Transactional
@Rollback(value = false)
class PortfolioRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    PortfolioRepository portfolioRepository;

    Member member;

    @BeforeEach
    void setup() {
        member = new Member();
        em.persist(member);
        em.flush();
        em.clear();
    }

//    @Test
//    void portfolioInsertTest() {
//        BasicInfo basicInfo = new BasicInfo("name", "Email@email", "200-12323");
//        Portfolio portfolio = new Portfolio(basicInfo);
//        portfolioRepository.save(portfolio);
//
//        Portfolio foundPortfolio = portfolioRepository.getById(portfolio.getId());
//        Assertions.assertThat(foundPortfolio.getBasicInfo().getName()).isEqualTo(basicInfo.getName());
//        Assertions.assertThat(foundPortfolio.getBasicInfo().getEmail()).isEqualTo(basicInfo.getEmail());
//        Assertions.assertThat(foundPortfolio.getBasicInfo().getMobile()).isEqualTo(basicInfo.getMobile());
//        Assertions.assertThat(foundPortfolio.getMember().getId()).isEqualTo(member.getId());
//    }
}