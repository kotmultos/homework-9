package org.example;

public class MyStack implements Stackable{
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
    public boolean push(int elem) {
        boolean result = false;
        if(!isFull()) {
            top++;
            stackArray[top] = elem;
        }
        return result;
    }

    @Override
    public int pop() {
        if(!isEmpty()) {
            return stackArray[top--];
        }
        else {
            return Integer.MAX_VALUE;
        }
    }

    @Override
    public int readTop() {
        return stackArray[top];
    }
}
