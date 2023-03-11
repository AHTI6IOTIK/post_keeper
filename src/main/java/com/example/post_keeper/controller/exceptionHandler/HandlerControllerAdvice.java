package com.example.post_keeper.controller.exceptionHandler;

import com.example.post_keeper.app.dto.DescriptionResponse;
import com.example.post_keeper.app.dto.Violation;
import com.example.post_keeper.app.exception.BadRequestException;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerControllerAdvice {

    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DescriptionResponse onNotFoundEntityExceptionHandler(BadRequestException e) {
        return new DescriptionResponse(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Violation> onConstraintViolationExceptionHandler(ConstraintViolationException e) {
        return e.getConstraintViolations()
            .stream()
            .map((v) -> new Violation(v.getPropertyPath().toString(), v.getMessage()))
            .collect(Collectors.toList());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Violation> onMethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return e.getBindingResult()
            .getFieldErrors()
            .stream()
            .map((v) -> new Violation(v.getField(), v.getDefaultMessage()))
            .collect(Collectors.toList());
    }
}
