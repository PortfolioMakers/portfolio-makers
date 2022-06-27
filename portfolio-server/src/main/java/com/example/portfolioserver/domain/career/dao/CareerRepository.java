package com.example.portfolioserver.domain.career.dao;

import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Long> {
    List<Career> findAllByPortfolio(Portfolio portfolio);

    @Transactional
    @Modifying
    @Query("delete from Career c where c.portfolio = :portfolio and c.id not in :ids")
    void deleteIdsNotIn(@Param("portfolio") Portfolio portfolio, @Param("ids") List<Long> ids);
}
