package com.movieflix.exception;

public class UserNameOrPasswordInvalidException extends RuntimeException {
    public UserNameOrPasswordInvalidException(String message) {
        super(message);
    }
}
