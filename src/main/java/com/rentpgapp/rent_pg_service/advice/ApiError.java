package com.rentpgapp.rent_pg_service.advice;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiError {
    private HttpStatus httpStatus;
    private String message;
    private LocalDateTime createdAt;
}
