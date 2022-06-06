package com.example.portfolioserver.domain.educationalhistory.dao;

import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalHistoryRepository extends JpaRepository<EducationalHistory, Long> { }