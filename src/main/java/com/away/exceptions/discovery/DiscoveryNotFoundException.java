package com.away.exceptions.discovery;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DiscoveryNotFoundException extends RuntimeException {


    public DiscoveryNotFoundException(long id) {
        super("Discovery number " + id + " not found!");
    }


}
