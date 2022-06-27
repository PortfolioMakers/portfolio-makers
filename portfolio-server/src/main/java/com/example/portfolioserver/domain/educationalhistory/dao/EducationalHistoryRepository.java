package com.example.portfolioserver.domain.educationalhistory.dao;

import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EducationalHistoryRepository extends JpaRepository<EducationalHistory, Long> {
    List<EducationalHistory> findAllByPortfolio(Portfolio portfolio);

    @Transactional
    @Modifying
    @Query("delete from EducationalHistory eh where eh.portfolio = :portfolio and eh.id not in :ids")
    void deleteIdsNotIn(@Param("portfolio") Portfolio portfolio, @Param("ids") List<Long> ids);
}