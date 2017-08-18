package com.zadanie.zadanie2.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String description){
        super(description);
    }
}
