package com.vhrybyniuk.datastructures.queue;

import com.vhrybyniuk.datastructures.interfaces.Queue;

public class ArrayQueue implements Queue {
    private int size;
    private Object[] arrayQueue;

    public ArrayQueue() {
        arrayQueue = new Object[10];
    }

    public ArrayQueue(int initCapacity) {
        arrayQueue = new Object[initCapacity];
    }

    @Override
    public void enqueue(Object value) {
        assignCapacity();
        arrayQueue[size++] = value;
    }


    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        Object dequeueFiertElement = arrayQueue[0];

        Object[] newQueue = new Object[arrayQueue.length - 1];
        size--;

        for (int i = 1; i < arrayQueue.length; i++) {
            newQueue[i - 1] = arrayQueue[i];
        }

        arrayQueue = newQueue;
        return dequeueFiertElement;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public Object browse() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return arrayQueue[0];
    }


    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public boolean isContains(Object value) {
        for (int i = 0; i < arrayQueue.length; i++) {
            Object valueInQueue = value;
            if (valueInQueue.equals(arrayQueue[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < size; i++) {
            string += arrayQueue[i];
            if (i == size-1) {
                break;
            } else {
                string += ",";
                string += " ";
            }
        }
        return "[" + string + "]";
    }

    private void assignCapacity() {
        if (arrayQueue.length == size) {
            Object[] newArray = new Object[arrayQueue.length * 2];
            for (int i = 0; i < arrayQueue.length; i++) {
                newArray[i] = arrayQueue[i];
            }
            arrayQueue = newArray;
        }
    }

}
