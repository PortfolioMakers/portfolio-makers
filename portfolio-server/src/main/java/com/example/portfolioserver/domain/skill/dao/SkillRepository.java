package com.example.portfolioserver.domain.skill.dao;

import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.skill.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findAllByPortfolio(Portfolio portfolio);

    @Transactional
    @Modifying
    @Query("delete from Skill s where s.portfolio = :portfolio and s.id not in :ids")
    void deleteIdsNotIn(@Param("portfolio") Portfolio portfolio, @Param("ids") List<Long> ids);
}
