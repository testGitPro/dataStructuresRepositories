package com.vhrybyniuk.datastructures.linkedlist;

import com.vhrybyniuk.datastructures.interfaces.List;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList implements List {
    static class Node {
        Object element;
        Node next;

        public Node(Object element) {
            this.element = element;
        }
    }

    private int size;
    private Node first;
    private Node last;


    @Override
    public void add(Object value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(Object value, int index) {
        Objects.checkIndex(index, size + 1);
        Node newNode = new Node(value);
        if (first == null) {
            first = last = newNode;
        } else if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else if (index == size) {
            last.next = newNode;
            last = newNode;
        } else {
            Node current = getNodebyIndex(index - 1);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    private Node getNodebyIndex(int index) {
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public Object remove(int index) {
        Objects.checkIndex(index, size);
        Object removedEl;
        if (index == 0) {
            removedEl = first.element;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node prev = getNodebyIndex(index - 1);
            removedEl = prev.element;
            prev.next = prev.next.next;
            if (index == size - 1) {
                last = prev;
            }
        }
//        Node previousNode = getNodebyIndex(index-1);
        //       Object element = previousNode.next;
        //       previousNode.next=previousNode.next.next;
        size--;
        return removedEl;
    }

    @Override
    public Object get(int index) {
        Objects.checkIndex(index, size + 1);
        return getNodebyIndex(index).element;
    }

    public Object getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    public Object getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size - 1);
    }

    @Override
    public Object set(Object value, int index) {
        Objects.checkIndex(index, size + 1);
        Node node = getNodebyIndex(index - 1);
        node.element = value;

        return node;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object value) {
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(value)) {
                return true;
            }
            current = current.next;

        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        if (isEmpty()) {
            throw new IllegalStateException("Empty List");
        }
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (value.equals(current.element)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node current = last;

        if (isEmpty()) {
            throw new IllegalStateException("Empty List");
        }
        Node prevElement = getNodebyIndex(size - 2);

        for (int i = size - 1; i >= 0; i--) {
            if (value.equals(current.element)) {
                return i;
            }
            current = prevElement;
        }
        return -1;
    }
}


