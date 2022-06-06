package com.example.portfolioserver.domain.portfolio.dao;

import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    @Query(value = "select p from Portfolio p join fetch p.basicInfo b join fetch p.member m where p.id = :id")
    Optional<Portfolio> Search(@Param(value = "id") Long id);
}