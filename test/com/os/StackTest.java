package com.os;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class StackTest {
    Stack<Integer> stack = new Stack<>();

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    public void setUp() throws Exception {

        stack.push(21);
        stack.push(52);
        stack.push(83);
        stack.push(41);
        stack.push(56);
        stack.push(23);
    }

    @Test
    void isEmpty() {
        assertEquals(stack.isEmpty(), false);
        stack.deleteAll();
        assertEquals(stack.isEmpty(), true);
    }

    @Test
    void size() {
        assertEquals(stack.size(), 6);
    }

    @Test
    void push() {
        assertEquals(stack.size(), 6);
        stack.push(100);
        assertEquals(stack.size(), 7);
    }

    @Test
    void pop() {
        assertEquals(stack.size(), 6);
        stack.pop();
        assertEquals(stack.size(), 5);

    }

    @Test
    void deleteAll() {
        stack.deleteAll();
        assertEquals(stack.size(), 0);
    }

    @Test
    void peek() {
        int num = stack.peek();
        assertEquals(num, 23);

    }

    @Test
    void toStringTest() {
        assertEquals(stack.toString(), 23 + "\n" + 56 + "\n" + 41 + "\n" + 83+ "\n" + 52 + "\n" + 21 + "\n");
    }

}