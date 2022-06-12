package com.example.portfolioserver.domain.educationalhistory.application;

import com.example.portfolioserver.domain.educationalhistory.dao.EducationalHistoryRepository;
import com.example.portfolioserver.domain.educationalhistory.dto.EducationalHistoryDto;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationalHistoryEditServiceImpl implements EducationalHistoryEditService{

    private final EducationalHistoryRepository educationalHistoryRepository;

    public void Edit(Portfolio portfolio, List<EducationalHistoryDto> educationalHistoryDtos) {
        List<Long> ids = educationalHistoryDtos.stream().map(EducationalHistoryDto::getId).filter(Objects::nonNull).collect(Collectors.toList());
        educationalHistoryRepository.deleteIdsNotIn(portfolio, ids);
        List<EducationalHistory> educationalHistories = educationalHistoryDtos.stream().map(educationalHistoryDto -> educationalHistoryDto.getEntity(portfolio)).collect(Collectors.toList());
        educationalHistoryRepository.saveAll(educationalHistories);
    }
}
