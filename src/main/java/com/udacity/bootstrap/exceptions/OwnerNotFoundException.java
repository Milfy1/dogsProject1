package com.udacity.bootstrap.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "owner not found")
public class OwnerNotFoundException extends RuntimeException {
    public OwnerNotFoundException(String s) {
        super(s);
    }
}
