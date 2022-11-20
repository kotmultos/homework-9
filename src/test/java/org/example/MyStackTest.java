package org.example;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    @Test
    public void testIsEmpty_empty() {
        MyStack stack = new MyStack(2);
        assertTrue(stack.isEmpty());
    }
    @Test
    public void testIsEmpty_notEmpty() {
        MyStack stack = new MyStack(2);
        try {
            stack.push(10);
        } catch (MyStackOverflowException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(stack.isEmpty());
    }
    @Test
    public void testIsFull_full() {
        MyStack stack = new MyStack(2);
        try {
            stack.push(10);
            stack.push(20);
        } catch (MyStackOverflowException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(stack.isFull());
    }
    @Test
    public void testIsFull_notFull() {
        MyStack stack = new MyStack(2);
        try {
            stack.push(10);
        } catch (MyStackOverflowException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(stack.isFull());
    }
    @Test
    public void testPush_ordinary() {
        MyStack stack = new MyStack(2);
        try {
            assertTrue(stack.push(10));
        } catch (MyStackOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testPush_fullStackCheckException() {
        Exception exception = assertThrows(MyStackOverflowException.class, () -> {
            MyStack stack = new MyStack(2);
            stack.push(30);
            stack.push(30);
            stack.push(10);
        });

        String expectedMessage = "Stack is full. The overflow occurred.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void testPop_full() {
        MyStack stack = new MyStack(2);
        try {
            stack.push(20);
            stack.push(30);
            assertEquals(30, stack.pop());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testPop_ordinary() {
        MyStack stack = new MyStack(2);
        try {
            stack.push(20);
            assertEquals(20, stack.pop());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testPop_emptyCheckException() {
        Exception exception = assertThrows(MyStackEmptyException.class, () -> {
            MyStack stack = new MyStack(2);
            stack.pop();
        });

        String expectedMessage = "The stack is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testReadTop_ordinary() {
        MyStack stack = new MyStack(2);
        try {
            stack.push(20);
            assertEquals(20, stack.readTop());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testReadTop_emptyCheckException() {
        Exception exception = assertThrows(MyStackEmptyException.class, () -> {
            MyStack stack = new MyStack(2);
            stack.readTop();
        });

        String expectedMessage = "The stack is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPopOptional_null() {
        MyStack stack = new MyStack(2);
        try {
            stack.push(10);
        } catch (MyStackOverflowException e) {
            System.out.println(e.getMessage());
        }
        Optional <Integer> optional = stack.popOptional();
        assertTrue(optional.isPresent());
    }

    @Test
    public void testPopOptional_notNull() {
        MyStack stack = new MyStack(2);
        Optional <Integer> optional = stack.popOptional();
        assertFalse(optional.isPresent());
    }
}