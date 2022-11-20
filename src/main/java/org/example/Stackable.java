package org.example;

public interface Stackable {
    boolean isEmpty();
    boolean isFull();
    boolean push(int elem) throws MyStackOverflowException;
    int pop() throws MyStackEmptyException;
    int readTop() throws MyStackEmptyException;
}
