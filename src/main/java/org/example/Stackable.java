package org.example;

public interface Stackable {
    boolean isEmpty();
    boolean isFull();
    boolean push(int elem);
    int pop();
    int readTop();
}
