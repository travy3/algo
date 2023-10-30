package com.zyu.ds.link;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    /**
     * isEmpty
     * <p>
     * size
     * <p>
     * contains
     * <p>
     * add
     * <p>
     * addLast
     * <p>
     * addFirst
     * <p>
     * removeFirst
     * <p>
     * removeLast
     */

    private Node<T> head;
    private Node<T> tail;
    int size;

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = head.next;
        }
        return false;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T data = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }


    public T removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        T data = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }


}