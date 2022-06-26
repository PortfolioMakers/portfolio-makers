package com.example.portfolioserver.domain.portfolio.application.v1;

import com.example.portfolioserver.domain.award.application.AwardRegisterService;
import com.example.portfolioserver.domain.basicinfo.dao.BasicInfoRepository;
import com.example.portfolioserver.domain.basicinfo.entity.BasicInfo;
import com.example.portfolioserver.domain.career.application.CareerRegisterService;
import com.example.portfolioserver.domain.educationalhistory.application.EducationalHistoryRegisterService;
import com.example.portfolioserver.domain.member.dao.MemberRepository;
import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.portfolio.dao.PortfolioRepository;
import com.example.portfolioserver.domain.portfolio.dto.v1.PortfolioDto;
import com.example.portfolioserver.domain.portfolio.entity.Portfolio;
import com.example.portfolioserver.domain.professionalexperience.application.ProfessionalExperienceRegisterService;
import com.example.portfolioserver.domain.skill.application.SkillRegisterService;
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
    private final ProfessionalExperienceRegisterService professionalExperienceRegisterService;
    private final AwardRegisterService awardRegisterService;
    private final SkillRegisterService skillRegisterService;

    public Long Register(Long memberId, PortfolioDto portfolioDto) {
        Portfolio portfolio = registerPortfolio(memberId, portfolioDto);
        educationalHistoryRegisterService.Register(portfolio, portfolioDto.getEducationalHistoryDtos());
        careerRegisterService.Register(portfolio, portfolioDto.getCareerDtos());
        professionalExperienceRegisterService.Register(portfolio, portfolioDto.getProfessionalExperienceDtos());
        awardRegisterService.Register(portfolio, portfolioDto.getAwardDtos());
        skillRegisterService.Register(portfolio, portfolioDto.getSkillDtos());
        return portfolio.getId();
    }

    private Portfolio registerPortfolio(Long memberId, PortfolioDto portfolioDto) {
        Member member = getMember(memberId);
        if(portfolioRepository.existsByMember(member)) {
            throw new IllegalArgumentException("포트폴리오가 이미 등록되어 있습니다.");
        }
        BasicInfo basicInfo = basicInfoRepository.save(portfolioDto.getBasicInfoDto().toEntity());
        return portfolioRepository.save(Portfolio.create(member, basicInfo));
    }

    private Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("사용자 아이디가 없습니다."));
    }
}
