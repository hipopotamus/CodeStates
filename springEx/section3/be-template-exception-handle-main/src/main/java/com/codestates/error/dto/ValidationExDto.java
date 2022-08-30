package com.codestates.error.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ValidationExDto {
    List<FieldErrorDto> fieldErrorDtoList;
    List<ConstraintViolationErrorDto> constraintViolationErrorDtoList;

    private ValidationExDto(List<FieldErrorDto> fieldErrorDtoList, List<ConstraintViolationErrorDto> constraintViolationErrorDtoList) {
        this.fieldErrorDtoList = fieldErrorDtoList;
        this.constraintViolationErrorDtoList = constraintViolationErrorDtoList;
    }

    public static ValidationExDto of(List<FieldError> fieldErrorList) {
        return new ValidationExDto(fieldErrorToDto(fieldErrorList), null);
    }

    public static ValidationExDto of(Set<ConstraintViolation<?>> constraintViolationSet) {
        return new ValidationExDto(null, constraintViolationErrorToDto(constraintViolationSet));
    }

    public static ValidationExDto of(List<FieldError> fieldErrorList, Set<ConstraintViolation<?>> constraintViolationSet) {
        return new ValidationExDto(fieldErrorToDto(fieldErrorList), constraintViolationErrorToDto(constraintViolationSet));
    }

    private static List<FieldErrorDto> fieldErrorToDto(List<FieldError> fieldErrorList) {
        return fieldErrorList.stream()
                .map(fieldError ->
                        FieldErrorDto.builder()
                                .field(fieldError.getField())
                                .rejectedValue(fieldError.getRejectedValue())
                                .DefaultMessage(fieldError.getDefaultMessage())
                                .build())
                .collect(Collectors.toList());
    }

    private static List<ConstraintViolationErrorDto> constraintViolationErrorToDto(Set<ConstraintViolation<?>> constraintViolationSet) {
        return constraintViolationSet.stream()
                .map(constraintViolation ->
                        ConstraintViolationErrorDto.builder()
                                .propertyPath(constraintViolation.getPropertyPath().toString())
                                .rejectedValue(constraintViolation.getInvalidValue())
                                .reason(constraintViolation.getMessage())
                                .build())
                .collect(Collectors.toList());
    }


    @Data
    @Builder
    @AllArgsConstructor
    public static class FieldErrorDto {
        private String field;
        private Object rejectedValue;
        private String DefaultMessage;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class ConstraintViolationErrorDto {
        private String propertyPath;
        private Object rejectedValue;
        private String reason;
    }
}
