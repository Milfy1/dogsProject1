package com.udacity.bootstrap.advice;
import com.udacity.bootstrap.exceptions.AirTagNotFoundException;
import com.udacity.bootstrap.exceptions.DogNotFoundException;
import com.udacity.bootstrap.exceptions.OwnerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    //one way to do it
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handelInvalidArgument(MethodArgumentNotValidException exception){
        Map<String,String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->{
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
    //simpler response
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + ex.getMessage());
    }

    @ExceptionHandler(DogNotFoundException.class)
    public ResponseEntity<String> handleDogNotFoundException(DogNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Dog not found: " + ex.getMessage());
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    public ResponseEntity<String> handleOwnerNotFoundException(OwnerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Owner not found: " + ex.getMessage());
    }
    @ExceptionHandler(AirTagNotFoundException.class)
    public ResponseEntity<String> handleAirTagNotFoundException(AirTagNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("AirTag not found: " + ex.getMessage());
    }
}
