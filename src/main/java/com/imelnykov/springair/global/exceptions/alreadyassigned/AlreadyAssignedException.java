package com.imelnykov.springair.global.exceptions.alreadyassigned;

public class AlreadyAssignedException extends RuntimeException {
    public AlreadyAssignedException(String message) {
        super(message);
    }
}
