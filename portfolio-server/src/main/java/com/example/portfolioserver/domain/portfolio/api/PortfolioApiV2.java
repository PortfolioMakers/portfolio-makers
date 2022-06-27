package com.example.portfolioserver.domain.portfolio.api;

import com.example.portfolioserver.domain.portfolio.application.v2.PortfolioV2EditService;
import com.example.portfolioserver.domain.portfolio.application.v2.PortfolioV2RegisterService;
import com.example.portfolioserver.domain.portfolio.application.v2.PortfolioV2SearchService;
import com.example.portfolioserver.domain.portfolio.dto.v2.PortfolioV2Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolio/v2")
public class PortfolioApiV2 {

    private final PortfolioV2RegisterService portfolioV2RegisterService;
    private final PortfolioV2SearchService portfolioV2SearchService;
    private final PortfolioV2EditService portfolioV2EditService;

    @PostMapping("/{memberId}")
    public ResponseEntity Register(@PathVariable Long memberId, @Valid @RequestBody PortfolioV2Dto portfolioV2Dto) {
        Long id = portfolioV2RegisterService.Register(memberId, portfolioV2Dto);
        return ResponseEntity.created(URI.create("/portfolio/v2/" + id)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity Search(@PathVariable Long id) {
        return ResponseEntity.ok(portfolioV2SearchService.Search(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity Edit(@PathVariable Long id, @RequestBody PortfolioV2Dto portfolioV2Dto) {
        return ResponseEntity.ok(portfolioV2EditService.Edit(id, portfolioV2Dto));
    }
}
