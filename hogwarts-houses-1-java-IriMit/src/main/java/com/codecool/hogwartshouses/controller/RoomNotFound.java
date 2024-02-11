package com.codecool.hogwartshouses.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomNotFound extends Exception {

    public RoomNotFound() {
    }

    public RoomNotFound(String message) {
        super(message);
    }
}
