package com.away.exceptions;

public class ItemDoesntExistException extends RuntimeException {

    public ItemDoesntExistException(long id) {
        super("Item with id: " + id + " doesn't exist.");
    }


}
