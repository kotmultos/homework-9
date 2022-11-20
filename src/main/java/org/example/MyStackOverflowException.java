package org.example;

public class MyStackOverflowException extends Exception{
    public MyStackOverflowException() {
        super("Stack is full. The overflow occurred.");
    }
}
