package com.example.portfolioserver.domain.professionalexperience.dao;

import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.professionalexperience.entity.ProfessionalExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProfessionalExperienceRepository extends JpaRepository<ProfessionalExperience, Long> {
    List<ProfessionalExperience> findAllByPortfolio(Portfolio portfolio);

    @Transactional
    @Modifying
    @Query("delete from ProfessionalExperience pe where pe.portfolio = :portfolio and pe.id not in :ids")
    void deleteIdsNotIn(@Param("portfolio") Portfolio portfolio, @Param("ids") List<Long> ids);
}
