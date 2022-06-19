package com.example.portfolioserver.domain.portfolio.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotBlankIfContainsValidatorTest {

    @Test
    void isBlankTest() {
        assertTrue("".isBlank());
        assertTrue("".isEmpty());
        assertTrue("  ".isBlank());
        assertFalse("  ".isEmpty());
    }
}