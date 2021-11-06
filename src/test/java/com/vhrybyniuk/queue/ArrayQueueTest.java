package com.vhrybyniuk.queue;

import com.vhrybyniuk.datastructures.queue.ArrayQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {
    @Test
    void testEnqueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("JsonRequestId_1");
        arrayQueue.enqueue("JsonRequestId_2");
        arrayQueue.enqueue("JsonRequestId_3");
        assertEquals(3, arrayQueue.size());

    }


    @Test
    void testDequeue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("JsonRequestId_1");
        arrayQueue.enqueue("JsonRequestId_2");
        arrayQueue.enqueue("JsonRequestId_3");
        assertEquals("JsonRequestId_1", arrayQueue.dequeue());
        assertEquals("JsonRequestId_2", arrayQueue.dequeue());
        assertEquals(1, arrayQueue.size());

    }

    @Test
    public void testDequeueEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }


    @Test
    public void testBrowseEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.browse();
        });
    }


    @Test
    public void testBrowse() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("JsonRequestId_1");
        arrayQueue.enqueue("JsonRequestId_2");
        arrayQueue.enqueue("JsonRequestId_3");

        assertEquals(arrayQueue.size(),3);
        assertEquals("JsonRequestId_1", arrayQueue.browse());
        assertEquals(arrayQueue.size(),3);

    }



    @Test
    public void testClear() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("JsonRequestId_1");
        arrayQueue.enqueue("JsonRequestId_2");
        arrayQueue.enqueue("JsonRequestId_3");
        assertEquals(3, arrayQueue.size());

        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testContainsSuccess() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("JsonRequestId_1");
        arrayQueue.enqueue("JsonRequestId_2");
        arrayQueue.enqueue("JsonRequestId_3");

        assertTrue(arrayQueue.isContains(new String("JsonRequestId_3")));
    }

    @Test
    public void testContainsEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertFalse(arrayQueue.isContains(new String("JsonRequestId_1")));
    }

    @Test
    public void testContainsFailure(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("JsonRequestId_1");
        arrayQueue.enqueue("JsonRequestId_2");
        arrayQueue.enqueue("JsonRequestId_3");

        assertFalse(arrayQueue.isContains(new String("JsonRequestId")));
    }


    @Test
    void testIsEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());
    }


    @Test
    public void testToString(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("JsonRequestId_1");
        arrayQueue.enqueue("JsonRequestId_2");
        arrayQueue.enqueue("JsonRequestId_3");

        assertEquals("[JsonRequestId_1, JsonRequestId_2, JsonRequestId_3]", arrayQueue.toString());

    }



}


