package com.away.exceptions;

public class ItemAlreadyExistsException extends RuntimeException {

    public ItemAlreadyExistsException(long id) {
        super("Item with id: " + id + " already exists.");
    }
}