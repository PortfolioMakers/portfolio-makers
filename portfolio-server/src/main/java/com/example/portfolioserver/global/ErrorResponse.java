package com.example.portfolioserver.global;

import lombok.Getter;

import java.util.List;

@Getter
public class ErrorResponse {

    public ErrorResponse(String message, List<ErrorInfo> details) {
        super();
        this.message = message;
        this.details = details;
    }

    private String message;

    //Specific errors in API request processing
    private List<ErrorInfo> details;
}
