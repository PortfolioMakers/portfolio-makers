package com.example.portfolioserver.domain.award.application;

import com.example.portfolioserver.domain.award.dao.AwardRepository;
import com.example.portfolioserver.domain.award.dto.AwardDto;
import com.example.portfolioserver.domain.award.entity.Award;
import com.example.portfolioserver.domain.career.dto.CareerDto;
import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AwardEditServiceImpl implements AwardEditService {

    private final AwardRepository awardRepository;

    @Override
    public void Edit(Portfolio portfolio, List<AwardDto> awardDtos) {
        List<Long> ids = awardDtos.stream().map(AwardDto::getId).filter(Objects::nonNull).collect(Collectors.toList());
        awardRepository.deleteIdsNotIn(portfolio, ids);
        List<Award> awards = awardDtos.stream().map(awardDto -> awardDto.toEntity(portfolio)).collect(Collectors.toList());
        awardRepository.saveAll(awards);
    }
}
