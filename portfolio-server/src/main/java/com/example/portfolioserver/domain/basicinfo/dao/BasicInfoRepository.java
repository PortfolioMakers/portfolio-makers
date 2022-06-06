package com.example.portfolioserver.domain.basicinfo.dao;

import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicInfoRepository extends JpaRepository<BasicInfo, Long> {
}
