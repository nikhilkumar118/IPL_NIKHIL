package com.edutech.progressive.exception;

public class NoMatchesFoundException extends RuntimeException{

    public NoMatchesFoundException(String string) {
        super(string);
    }
}