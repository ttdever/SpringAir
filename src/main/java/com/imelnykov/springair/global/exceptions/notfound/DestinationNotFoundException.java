package com.imelnykov.springair.global.exceptions.notfound;

public class DestinationNotFoundException extends NotFoundException {
    private static final String MESSAGE_TEMPLATE = "Destination with id=%d not found";

    public DestinationNotFoundException(int destinationId) {
        super(String.format(MESSAGE_TEMPLATE, destinationId));
    }
}
