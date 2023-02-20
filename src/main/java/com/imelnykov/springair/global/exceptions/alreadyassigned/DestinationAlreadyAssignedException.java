package com.imelnykov.springair.global.exceptions.alreadyassigned;

public class DestinationAlreadyAssignedException extends AlreadyAssignedException{
    private static final String MESSAGE_TEMPLATE = "User %d already has destination %d";

    public DestinationAlreadyAssignedException(int userId, int destinationId) {
        super(String.format(MESSAGE_TEMPLATE, userId, destinationId));
    }
}
