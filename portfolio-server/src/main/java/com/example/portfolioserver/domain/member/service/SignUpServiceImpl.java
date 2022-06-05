package com.example.portfolioserver.domain.member.service;

import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.member.repository.MemberRepository;
import com.example.portfolioserver.domain.member.validator.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final MemberRepository memberRepository;
    private final MemberValidator memberValidator;

    @Override
    @Transactional
    public void register(Member member) {
        memberValidator.Duplicate(member.getEmail());
        memberRepository.save(member);

    }

    @Override
    public Optional<Member> findMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
