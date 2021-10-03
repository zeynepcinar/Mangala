package com.cinar.Mangala.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GameNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2576221153177453295L;

    public GameNotFoundException(String message) {
        super(message);
    }

}