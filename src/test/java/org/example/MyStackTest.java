package org.example;

import junit.framework.TestCase;

public class MyStackTest extends TestCase {

    public void testIsEmpty_empty() {
        MyStack stack = new MyStack(2);
        assertTrue(stack.isEmpty());
    }

    public void testIsEmpty_notEmpty() {
        MyStack stack = new MyStack(2);
        stack.push(10);
        assertFalse(stack.isEmpty());
    }

    public void testIsFull_full() {
        MyStack stack = new MyStack(2);
        stack.push(10);
        stack.push(20);
        assertTrue(stack.isFull());
    }

    public void testIsFull_notFull() {
        MyStack stack = new MyStack(2);
        stack.push(10);
        assertFalse(stack.isFull());
    }

    public void testPush_ordinary() {
        MyStack stack = new MyStack(2);
        assertTrue(stack.push(10));
    }

    public void testPush_fullStack() {
        MyStack stack = new MyStack(2);
        stack.push(20);
        stack.push(30);
        assertFalse(stack.push(10));
    }

    public void testPop_full() {
        MyStack stack = new MyStack(2);
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop());
    }

    public void testPop_ordinary() {
        MyStack stack = new MyStack(2);
        stack.push(20);
        assertEquals(20, stack.pop());
    }

    public void testPop_empty() {
        MyStack stack = new MyStack(2);
        assertEquals(Integer.MAX_VALUE, stack.pop());
    }

    public void testReadTop_ordinary() {
        MyStack stack = new MyStack(2);
        stack.push(20);
        assertEquals(20, stack.readTop());
    }

    public void testReadTop_empty() {
        MyStack stack = new MyStack(2);
        assertEquals(Integer.MAX_VALUE, stack.readTop());
    }
}