package com.vhrybyniuk.linkedlist;

import com.vhrybyniuk.datastructures.linkedlist.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    @Test
    void testAddIntoEmptyList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        assertEquals(3, linkedList.size());
    }

    @Test
    void testGetFirstElementFromList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");

        Object object = linkedList.get(0);

        assertEquals("a", object);

    }

    @Test
    void testAddUsingIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add(null);

        assertEquals(4, linkedList.size());
        linkedList.add("c");
        assertEquals(5, linkedList.size());
    }

    @Test
    void testGetFirstElementFromEmptyList() {
        LinkedList linkedList = new LinkedList();
        assertThrows(NullPointerException.class, () -> linkedList.get(0));
    }

    @Test
    void testGetElementByNegativeIndex() {
        LinkedList linkedList = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
    }

    @Test
    void testSetElementByIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add(null);

        int index = 1;
        linkedList.set("qwerty", index);

        assertEquals("b", linkedList.get(index));
        assertEquals(4, linkedList.size());

    }

    @Test
    void testRemoveElementFromEmptyList() {
        LinkedList linkedList = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(234));
    }

    @Test
    void testRemoveElement() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.remove(0);

        assertEquals("b", linkedList.get(0));
        assertEquals(2, linkedList.size());
    }

    @Test
    void testRemoveLastElement() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.remove(linkedList.size() - 1);

        assertEquals("b", linkedList.get(linkedList.size() - 1));
        assertEquals(2, linkedList.size());
    }

    @Test
    void testIsEmpty() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add(null);

        boolean empty = linkedList.isEmpty();
        assertFalse(empty);
    }

    @Test
    void testClearOnEmptyList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add(null);
        linkedList.clear();

        assertEquals(0, linkedList.size());
    }

    @Test
    void testClearDropElements() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");

        linkedList.clear();
        assertThrows(NullPointerException.class, () -> linkedList.get(0));
    }

    @Test
    void testContainValues() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("y");
        linkedList.add("v");
        linkedList.add("w");
        linkedList.add("r");

        boolean containsExistingElement = linkedList.contains("a");
        boolean containsNotExistingElement = linkedList.contains("z");

        assertTrue(containsExistingElement);
        assertFalse(containsNotExistingElement);
    }

    @Test
    public void testIndexOf() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("a");
        linkedList.add("bx");

        assertEquals(1, linkedList.indexOf("b"));

    }

    @Test
    public void testLastIndexOf() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("a");
        linkedList.add("bx");

        assertEquals(3, linkedList.lastIndexOf("a"));

    }
}

