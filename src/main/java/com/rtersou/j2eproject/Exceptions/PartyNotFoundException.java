package com.rtersou.j2eproject.Exceptions;

public class PartyNotFoundException extends RuntimeException {
    public PartyNotFoundException(Long id) {
        super("Could not find Party " + id);
    }
}
