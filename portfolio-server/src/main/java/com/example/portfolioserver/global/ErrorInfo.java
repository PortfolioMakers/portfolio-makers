package com.example.portfolioserver.global;

import lombok.Getter;

@Getter
public class ErrorInfo {
    private String field;
    private String message;

    public ErrorInfo(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
