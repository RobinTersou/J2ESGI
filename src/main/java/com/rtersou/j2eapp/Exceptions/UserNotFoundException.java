package com.rtersou.j2eapp.Exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not find User " + id);
    }
}
