package com.Exceptions;

public class TutorNotFoundException extends Exception {
    public TutorNotFoundException(){
        super("No tutor found!");
    }
}
