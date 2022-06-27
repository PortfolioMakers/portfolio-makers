package com.example.portfolioserver.domain.award.application;

import com.example.portfolioserver.domain.award.dao.AwardRepository;
import com.example.portfolioserver.domain.award.dto.AwardDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AwardRegisterServiceImpl implements AwardRegisterService {

    private final AwardRepository awardRepository;

    @Override
    public void Register(Portfolio portfolio, List<AwardDto> awardDtos) {
        awardDtos.forEach(awardDto -> awardRepository.save(awardDto.toEntity(portfolio)));
    }
}
