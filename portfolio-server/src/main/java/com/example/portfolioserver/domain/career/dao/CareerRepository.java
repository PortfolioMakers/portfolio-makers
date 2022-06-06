package com.example.portfolioserver.domain.career.dao;

import com.example.portfolioserver.domain.career.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
}
