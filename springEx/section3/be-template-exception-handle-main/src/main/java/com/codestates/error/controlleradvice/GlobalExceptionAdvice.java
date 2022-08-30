package com.codestates.error.controlleradvice;

import com.codestates.error.dto.ValidationExDto;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler
    public ValidationExDto handleConstraintViolationEx(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolationSet = e.getConstraintViolations();
        return ValidationExDto.of(constraintViolationSet);
    }

    @ExceptionHandler
    public ValidationExDto handleBindEx(BindException e) {
        List<FieldError> fieldErrorList = e.getFieldErrors();
        return ValidationExDto.of(fieldErrorList);
    }

//    @ExceptionHandler({BindException.class, ConstraintViolationException.class})
//    public ValidationExDto handleValidationEx(BindException bindException,
//                                              ConstraintViolationException constraintViolationException) {
//        List<FieldError> fieldErrorList = bindException.getFieldErrors();
//        Set<ConstraintViolation<?>> constraintViolationSet = constraintViolationException.getConstraintViolations();
//        return ValidationExDto.of(fieldErrorList, constraintViolationSet);
//    }
}
