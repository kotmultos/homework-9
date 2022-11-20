package org.example;

import java.util.Optional;

public class MyStack implements Stackable {
    private int size;
    private int[] stackArray;
    private int top;

    public MyStack(int count) {
        this.size = count;
        this.stackArray = new int[count];
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == size - 1;
    }

    @Override
    public boolean push(int elem) throws MyStackOverflowException {
        if (isFull()) {
            throw new MyStackOverflowException();
        }
        top++;
        stackArray[top] = elem;
        return true;
    }

    @Override
    public int pop() throws MyStackEmptyException {
        if (isEmpty()) {
            throw new MyStackEmptyException();
        }
        return stackArray[top--];
    }

    @Override
    public int readTop() throws MyStackEmptyException {
        if (isEmpty()) {
            throw new MyStackEmptyException();
        }
        return stackArray[top];
    }

    public Optional<Integer> popOptional() {
        Optional<Integer> optional;
        if (isEmpty()) {
            optional = Optional.empty();
        } else {
            optional = Optional.of(stackArray[top]);
        }

        return optional;
    }
}
