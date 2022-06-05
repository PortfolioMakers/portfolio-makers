package com.example.portfolioserver.domain.member.validator;

import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberValidator {
    private final MemberRepository memberRepository;

    public void Duplicate(String email)  {
        Optional<Member> member = memberRepository.findByEmail(email);
        if(member.isPresent()) {
            //TODO - [수정필요] Exception 정의할 것
        }
    }
}
