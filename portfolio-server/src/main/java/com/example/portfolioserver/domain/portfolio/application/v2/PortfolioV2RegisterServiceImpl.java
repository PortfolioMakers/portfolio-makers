package com.example.portfolioserver.domain.portfolio.application.v2;

import com.example.portfolioserver.domain.member.dao.MemberRepository;
import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.portfolio.dao.PortfolioV2Repository;
import com.example.portfolioserver.domain.portfolio.dto.v2.PortfolioV2Dto;
import com.example.portfolioserver.domain.portfolio.entity.PortfolioV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PortfolioV2RegisterServiceImpl implements PortfolioV2RegisterService {

    private final MemberRepository memberRepository;
    private final PortfolioV2Repository portfolioRepository;

    @Override
    public Long Register(Long memberId, PortfolioV2Dto portfolioV2Dto) {
        PortfolioV2 portfolioV2 = portfolioV2Dto.toEntity(getMember(memberId));
        return portfolioRepository.save(portfolioV2).getId();
    }

    private Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("사용자 아이디가 없습니다."));
    }
}
