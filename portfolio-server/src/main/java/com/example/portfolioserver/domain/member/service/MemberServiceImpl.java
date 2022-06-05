package com.example.portfolioserver.domain.member.service;

import com.example.portfolioserver.api.member.dto.SignUpResponseDto;
import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.member.repository.MemberRepository;
import com.example.portfolioserver.domain.member.validator.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberValidator memberValidator;

    @Override
    @Transactional
    public SignUpResponseDto signUp(Member member) {
        memberValidator.Duplicate(member.getEmail());
        memberRepository.save(member);

        //TODO - Dto - entity 변환 어디서 할건 지 고민 해볼 것
        return SignUpResponseDto.builder()
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }

    @Override
    public Optional<Member> findMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
