package com.udacity.bootstrap.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "air tag not found")
public class AirTagNotFoundException extends RuntimeException {


    public AirTagNotFoundException() {
    }
    public AirTagNotFoundException(String message) {
        super(message);
    }
}
