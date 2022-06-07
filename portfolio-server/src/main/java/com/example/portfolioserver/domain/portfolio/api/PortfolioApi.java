package com.example.portfolioserver.domain.portfolio.api;

import com.example.portfolioserver.domain.portfolio.application.*;
import com.example.portfolioserver.domain.portfolio.dto.PortfolioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolio")
public class PortfolioApi {

    private final PortfolioRegisterService portfolioRegisterService;
    private final PortfolioSearchService portfolioSearchService;
    private final PortfolioEditService portfolioEditService;

    @PostMapping("/{memberId}")
    public ResponseEntity Register(@PathVariable Long memberId, @Valid @RequestBody PortfolioDto portfolioDto) {
        Long id = portfolioRegisterService.Register(memberId, portfolioDto);
        return ResponseEntity.created(URI.create("/portfolio/" + id)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity Search(@PathVariable Long id) {
        return ResponseEntity.ok(portfolioSearchService.Search(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity Edit(@PathVariable Long id, @RequestBody PortfolioDto portfolioDto) {
        return ResponseEntity.ok(portfolioEditService.Edit(id, portfolioDto));
    }
}
