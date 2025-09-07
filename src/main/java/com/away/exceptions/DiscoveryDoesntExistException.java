package com.away.exceptions;

public class DiscoveryDoesntExistException extends RuntimeException {

    public DiscoveryDoesntExistException(long id) {
        super("Discovery with id: " + id + " doesn't exist.");
    }


}
