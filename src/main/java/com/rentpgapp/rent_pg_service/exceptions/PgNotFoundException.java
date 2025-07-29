package com.rentpgapp.rent_pg_service.exceptions;

public class PgNotFoundException extends RuntimeException{
    public PgNotFoundException(String message) {
        super(message);
    }
}
