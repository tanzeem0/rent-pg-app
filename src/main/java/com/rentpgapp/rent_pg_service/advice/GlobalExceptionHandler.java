package com.rentpgapp.rent_pg_service.advice;

import com.rentpgapp.rent_pg_service.exceptions.PgNotFoundException;
import com.rentpgapp.rent_pg_service.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PgNotFoundException.class)
    public ApiError handlePgNotFoundException(PgNotFoundException e){
        return ApiError.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .createdAt(LocalDateTime.now()).build();

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ApiError handleUserNotFoundException(UserNotFoundException e){
        return ApiError.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .createdAt(LocalDateTime.now()).build();

    }

    @ExceptionHandler(RuntimeException.class)
    public ApiError handleRuntimeException(RuntimeException e){
        return ApiError.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.FORBIDDEN)
                .createdAt(LocalDateTime.now()).build();
    }
}
