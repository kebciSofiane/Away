package com.away.exceptions.item;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ItemAlreadyExistsException extends RuntimeException {

    public ItemAlreadyExistsException(long id) {
        super("Item number " + id + " already exists!");
    }
}