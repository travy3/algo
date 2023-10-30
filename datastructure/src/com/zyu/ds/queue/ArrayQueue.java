package com.zyu.ds.queue;

public class ArrayQueue<T> {
    public int capacity;

    private T[] arrayQueue;

    private int front;

    private int rear;


    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.arrayQueue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
    }


    public boolean isEmpty() {
        return rear < front;
    }

    public boolean isFull() {
        return rear >= capacity + 1;
    }

    public int size() {
        return rear - front + 1;
    }

    /**
     * offer()
     * @param element
     */
    public void enqueue(T element) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        arrayQueue[++rear] = element;
    }

    /**
     * poll()
     * @return
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arrayQueue[front++];
    }


}