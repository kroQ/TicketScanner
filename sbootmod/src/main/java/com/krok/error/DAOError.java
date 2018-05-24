package com.krok.error;

/**
 * Created by Mateusz Krok on 2018-04-19.
 */
public enum DAOError implements AppError {

    INVALID_EMAIL_ADDRESS("Invalid email address: {0}"),
    LOGIN_NOT_FOUND("Login: {0} not found"),
    EVENT_NOT_FOUND("Event: {0} not found"),
    EVENT_IS_NOT_UNIQUE("Event: {0} is already in use."),
    LOGIN_IS_NOT_UNIQUE("Login {0} is already in use."),
    TICKET_ALREADY_EXIST("Ticket {0} is already in use.");

    String message;

    DAOError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
