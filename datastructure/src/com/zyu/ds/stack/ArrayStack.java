package com.zyu.ds.stack;

public class ArrayStack<T> {
    private int capacity;

    private T[] stack;

    private int top;


    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.stack = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top >= capacity - 1;
    }

    public void push(T element) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }
        stack[++top] = element;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return stack[top--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return stack[top];
    }
}