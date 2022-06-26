package com.example.portfolioserver.domain.portfolio.api;

import com.example.portfolioserver.domain.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/portfolio")
public class PortfolioController {

    private final MemberService memberService;

    @GetMapping
    public String portfolio() {
        return "/portfolio";
    }

    @GetMapping("/test")
    public String test() {
        memberService.test();
        return "ok";
    }
}
