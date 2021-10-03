package com.cinar.Mangala.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ForbiddenMoveOnPitException extends RuntimeException {

    private static final long serialVersionUID = -2576221153177453295L;

    public ForbiddenMoveOnPitException(String message) {
        super(message);
    }
}

