package com.vhrybyniuk.datastructures.interfaces;

public interface Queue {
    void enqueue (Object value);

    Object dequeue();

    int size();

    boolean isEmpty();

    Object browse();

    boolean isContains(Object value);

    void clear();
}
