package com.example.portfolioserver.domain.portfolio.application;

import com.example.portfolioserver.domain.basicinfo.dao.BasicInfoRepository;
import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import com.example.portfolioserver.domain.career.application.CareerRegisterService;
import com.example.portfolioserver.domain.educationalhistory.application.EducationalHistoryRegisterService;
import com.example.portfolioserver.domain.member.dao.MemberRepository;
import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.portfolio.dao.PortfolioRepository;
import com.example.portfolioserver.domain.portfolio.dto.PortfolioDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortfolioRegisterServiceImpl implements PortfolioRegisterService {

    private final MemberRepository memberRepository;
    private final BasicInfoRepository basicInfoRepository;
    private final PortfolioRepository portfolioRepository;
    private final EducationalHistoryRegisterService educationalHistoryRegisterService;
    private final CareerRegisterService careerRegisterService;

    public Long Register(Long memberId, PortfolioDto portfolioDto) {
        Portfolio portfolio = registerPortfolio(memberId, portfolioDto);
        educationalHistoryRegisterService.Register(portfolio, portfolioDto.getEducationalHistoryDtos());
        careerRegisterService.Register(portfolio, portfolioDto.getCareerDtos());
        return portfolio.getId();
    }

    private Portfolio registerPortfolio(Long memberId, PortfolioDto portfolioDto) {
        BasicInfo basicInfo = basicInfoRepository.save(portfolioDto.getBasicInfoDto().getEntity());
        Portfolio portfolio = Portfolio.create(getMember(memberId), basicInfo);
        return portfolioRepository.save(portfolio);
    }

    private Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("사용자 아이디가 없습니다."));
    }
}
