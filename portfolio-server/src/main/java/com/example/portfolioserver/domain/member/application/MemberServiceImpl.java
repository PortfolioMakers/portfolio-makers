package com.example.portfolioserver.domain.member.application;

import com.example.portfolioserver.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final EntityManager em;

    @Override
    @Transactional
    public void test() {
        Member member = new Member();
        em.persist(member);
        em.detach(member);
    }
}
