package com.os;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
*
* Tests for MyQueue
*
 */

public class MyQueueTest {

    protected MyQueue<Integer> myQueue = new MyQueue<>();
    protected MyQueue<Integer> queue = new MyQueue<>();


    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

    }

    /**
     * Test method for MyQueue size.
     */
    @Test
    public void testMyQueueSize() {
        assertEquals(queue.size(), 3);
    }


    /**
     * Test method for {@link MyQueue#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertEquals(queue.isEmpty(), false);
        queue.deleteAll();
        assertEquals(queue.isEmpty(), true);
    }

    /**
     * Test method for {@link MyQueue#delete()}.
     */
    @Test
    public void testdelete() {
        Integer flag = queue.delete();
        assertEquals(java.util.Optional.of(flag), java.util.Optional.of(1));
        assertEquals(queue.size(), 2);


    }


    /**
     * Test method for {@link MyQueue#deleteAll()}.
     */
    @Test
    public void testdeleteAll() {
        queue.deleteAll();
        assertEquals(queue.size(), 0);
    }

    /**
     * Test method for {@link MyQueue#size()}.
     */
    @Test
    public void testSize() {
        assertEquals(queue.size(), 3);
    }


}
