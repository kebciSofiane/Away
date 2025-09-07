package com.away.exceptions;

public class UserDoesntExistException extends RuntimeException {

    public UserDoesntExistException(long id) {
        super("User with id: " + id + " doesn't exist.");
    }
    public UserDoesntExistException(String email) {
        super("User with email: " + email + " doesn't exist.");
    }

}
