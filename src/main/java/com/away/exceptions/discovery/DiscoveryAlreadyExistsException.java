package com.away.exceptions.discovery;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DiscoveryAlreadyExistsException extends RuntimeException {

    public DiscoveryAlreadyExistsException(long id) {
        super("Discovery number " + id + " already exists.");
    }
}