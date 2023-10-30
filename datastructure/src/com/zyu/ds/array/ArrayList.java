package com.zyu.ds.array;

import java.util.Arrays;

public class ArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;

    private int size;


    /**
     * constructor
     * <p>
     * add
     * <p>
     * get
     * <p>
     * <p>
     * size
     */

    public ArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        if (size == DEFAULT_CAPACITY) {
            resize();
        }
        elements[size++] = element;
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);

    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public int size() {
        return size;
    }

    public boolean empty(){
        return size==0;
    }

}