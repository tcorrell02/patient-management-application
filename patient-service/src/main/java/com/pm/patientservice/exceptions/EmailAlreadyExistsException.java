package com.pm.patientservice.exceptions;

//Custom exception for if an email already exists, enforces uniqueness
public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
