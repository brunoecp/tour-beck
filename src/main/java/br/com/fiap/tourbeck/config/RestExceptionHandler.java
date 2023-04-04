package br.com.fiap.tourbeck.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.fiap.tourbeck.Exception.RestNotFoundException;
import br.com.fiap.tourbeck.models.RestValidationErro;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class RestExceptionHandler {

    Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<RestValidationErro>> ConstraintViolationExceptionHadler(ConstraintViolationException e){

        List<RestValidationErro> errors = new ArrayList<>();

        e.getConstraintViolations().forEach((v)-> {
            errors.add(new RestValidationErro(v.getPropertyPath().toString(), v.getMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(RestNotFoundException.class)
    public ResponseEntity<Object> RestNotFoundExceptionHadler(RestNotFoundException e){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
    }
}
