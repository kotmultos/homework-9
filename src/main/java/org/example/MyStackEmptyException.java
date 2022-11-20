package org.example;

public class MyStackEmptyException extends Exception{
    public MyStackEmptyException() {
        super("The stack is empty");
    }
}
