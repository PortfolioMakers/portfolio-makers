package com.example.portfolioserver.domain.portfolio.dao;

import com.example.portfolioserver.domain.portfolio.entity.PortfolioV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioV2Repository extends JpaRepository<PortfolioV2,Long> {
    @Query(value = "select p2 from PortfolioV2 p2 " +
            "join fetch p2.basicInfoV2 b2 join fetch p2.member m where p2.id = :id")
    Optional<PortfolioV2> Search(@Param(value = "id") Long id);
}
