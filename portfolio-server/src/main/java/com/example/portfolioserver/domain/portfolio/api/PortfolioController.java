package com.example.portfolioserver.domain.portfolio.api;

import com.example.portfolioserver.domain.portfolio.dto.PortfolioDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/portfolio")
public class PortfolioController {

    @GetMapping
    public String portfolio() {
        return "/portfolio";
    }
}
