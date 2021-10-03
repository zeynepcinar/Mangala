package com.cinar.Mangala.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@AllArgsConstructor
public class ErrorDetails {
    private HttpStatus status;
    private String message;
    private Date timestamp;
}
