package com.vhrybyniuk.arraylist;

import com.vhrybyniuk.datastructures.arraylist.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    @Test
    public void testAddSimpleToList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        assertEquals("a", arrayList.get(0));
        assertEquals("b", arrayList.get(1));
        assertEquals("c", arrayList.get(2));
    }

    @Test
    public void testAddUsingIndexToList() {
        ArrayList arrayList = new ArrayList();
        String a = "a";
        for (int i = 0; i < 10; i++) {
            arrayList.add(a);
        }

        arrayList.add("b", 7);
        assertEquals("b", arrayList.get(7));

    }

    @Test
    public void testThrowIndexBoundsOfOutExceptionUnlimitedIndexAdd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(4);
        });
    }

    @Test
    public void testThrowIndexBoundsOfOutExceptionUnlimitedIndexGet() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("c", 4);
        });
    }


    @Test
    public void testRemoveByIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        arrayList.remove(1);

        assertEquals("a", arrayList.get(0));
        assertEquals("c", arrayList.get(1));
    }

    @Test
    public void testThrowIndexBoundsOfOutExceptionUnlimitedIndexRemove() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(3);
        });
    }


    @Test
    public void testListClear() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        assertEquals(3, arrayList.size());
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testEmptyListTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testEmptyListFalse() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");


        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testIndexOf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        assertEquals(-1, arrayList.indexOf(5));
        assertEquals(1, arrayList.indexOf("b"));
    }


    @Test
    public void testLastIndexOf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("a");
        arrayList.add("b");

        assertEquals(3, arrayList.lastIndexOf("a"));

    }

    @Test
    public void testSizeOfList() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= 100; i++) {
            arrayList.add(i);
        }
        assertEquals(101, arrayList.size());
    }

    @Test
    public void testSetToList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        assertEquals("a", arrayList.get(0));
        assertEquals("b", arrayList.get(1));
        assertEquals("c", arrayList.get(2));

        arrayList.set("g", 0);
        arrayList.set("qwerty", 1);
        arrayList.set(null, 2);

        assertEquals("g", arrayList.get(0));
        assertEquals("qwerty", arrayList.get(1));
        assertEquals(null, arrayList.get(2));

    }

    @Test
    public void testToStringArrayList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        assertEquals("[a,b,c]", arrayList.toString());
    }

}