package com.away.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(long id) {
        super("User number " + id + " not found");
    }
    public UserNotFoundException(String email) {
        super("User with email " + email + " not found!");
    }

}
