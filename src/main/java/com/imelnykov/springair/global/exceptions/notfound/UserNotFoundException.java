package com.imelnykov.springair.global.exceptions.notfound;

public class UserNotFoundException extends NotFoundException {
    private static final String MESSAGE_TEMPLATE = "Destination with id=%d not found";

    public UserNotFoundException(int userId) {
        super(String.format(MESSAGE_TEMPLATE, userId));
    }
}
