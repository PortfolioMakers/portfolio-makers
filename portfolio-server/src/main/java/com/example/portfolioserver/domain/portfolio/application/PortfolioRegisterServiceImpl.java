package com.example.portfolioserver.domain.portfolio.application;

import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import com.example.portfolioserver.domain.career.entity.Career;
import com.example.portfolioserver.domain.educationalhistory.entity.EducationalHistory;
import com.example.portfolioserver.domain.member.dao.MemberRepository;
import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.portfolio.dao.PortfolioRepository;
import com.example.portfolioserver.domain.portfolio.dto.PortfolioDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioRegisterServiceImpl implements PortfolioRegisterService {

    private final MemberRepository memberRepository;
    private final PortfolioRepository portfolioRepository;

    public Long Register(Long memberId, PortfolioDto portfolioDto) {
        Member member = getMember(memberId);
        BasicInfo basicInfo = portfolioDto.getBasicInfoDto().getEntity();
        List<EducationalHistory> educationalHistoryList = getEducationalHistoryList(portfolioDto);
        List<Career> careerList = getCareerList(portfolioDto);
        Portfolio portfolio = Portfolio.createPortfolio(member, basicInfo, educationalHistoryList, careerList);
        return portfolioRepository.save(portfolio).getId();
    }

    private Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("사용자 아이디가 없습니다."));
    }

    private List<EducationalHistory> getEducationalHistoryList(PortfolioDto portfolioDto) {
        return portfolioDto.getEducationalHistoryDtos().stream()
                .map(educationalHistoryDto -> educationalHistoryDto.getEntity())
                .collect(Collectors.toList());
    }

    private List<Career> getCareerList(PortfolioDto portfolioDto) {
        return portfolioDto.getCareerDtos().stream()
                .map(careerDto -> careerDto.getEntity())
                .collect(Collectors.toList());
    }
}
