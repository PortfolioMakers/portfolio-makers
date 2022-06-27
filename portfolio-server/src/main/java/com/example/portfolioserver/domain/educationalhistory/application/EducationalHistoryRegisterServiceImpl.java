package com.example.portfolioserver.domain.educationalhistory.application;

import com.example.portfolioserver.domain.educationalhistory.dao.EducationalHistoryRepository;
import com.example.portfolioserver.domain.educationalhistory.dto.EducationalHistoryDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationalHistoryRegisterServiceImpl implements EducationalHistoryRegisterService{

    private final EducationalHistoryRepository educationalHistoryRepository;

    public void Register(Portfolio portfolio, List<EducationalHistoryDto> educationalHistoryDtos) {
        educationalHistoryDtos.forEach(educationalHistoryDto -> educationalHistoryRepository.save(educationalHistoryDto.toEntity(portfolio)));
    }
}
