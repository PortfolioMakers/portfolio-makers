package com.example.portfolioserver.domain.award.dao;

import com.example.portfolioserver.domain.award.entity.Award;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AwardRepository extends JpaRepository<Award,Long> {
    List<Award> findAllByPortfolio(Portfolio portfolio);

    @Transactional
    @Modifying
    @Query("delete from Award a where a.portfolio = :portfolio and a.id not in :ids")
    void deleteIdsNotIn(@Param("portfolio") Portfolio portfolio, @Param("ids") List<Long> ids);
}
