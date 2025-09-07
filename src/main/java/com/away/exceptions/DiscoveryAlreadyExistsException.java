package com.away.exceptions;

public class DiscoveryAlreadyExistsException extends RuntimeException {

    public DiscoveryAlreadyExistsException(long id) {
        super("Discovery with id: " + id + " already exists.");
    }
}