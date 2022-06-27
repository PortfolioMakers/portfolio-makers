package com.example.portfolioserver.domain.portfolio.dao;

import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    boolean existsByMember(Member member);
}