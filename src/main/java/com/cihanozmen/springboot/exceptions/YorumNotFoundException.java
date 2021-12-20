package com.cihanozmen.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class YorumNotFoundException extends RuntimeException {
    public YorumNotFoundException(String message) {
        super(message);
    }
}
