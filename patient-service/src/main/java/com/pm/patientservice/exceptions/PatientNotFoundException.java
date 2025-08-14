package com.pm.patientservice.exceptions;

//Custom exception for when trying to update a non-existent patient in the database
public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String message) {
        super(message);
    }
}
