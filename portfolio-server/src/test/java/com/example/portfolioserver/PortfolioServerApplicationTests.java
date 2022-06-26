package com.example.portfolioserver;

import com.example.portfolioserver.domain.member.dao.MemberRepository;
import com.example.portfolioserver.domain.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@Transactional
class PortfolioServerApplicationTests {

    @Autowired
    private EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void contextLoads() {
        Member member = new Member();
        System.out.println(memberRepository.count());
        em.persist(member);
        em.clear();
    }
}
