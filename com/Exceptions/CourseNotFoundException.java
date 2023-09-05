package com.Exceptions;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException(){
        super("No course found!");
    }
}
