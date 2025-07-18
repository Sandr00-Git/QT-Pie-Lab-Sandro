package org.example;

public class QueueTees {
    private static final int MAX_SIZE = 10;
    private Cutie[] queue;
    private int front;
    private int rear;
    private int size;

    public QueueTees() {
        queue = new Cutie[MAX_SIZE];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(Cutie c) {
        if (size == MAX_SIZE) {
            System.out.println("Queue is full! Cannot enqueue.");
            return;
        }
        queue[rear] = c;
        rear = (rear + 1) % MAX_SIZE;
        size++;
    }

    public Cutie dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return null;
        }
        Cutie removed = queue[front];
        front = (front + 1) % MAX_SIZE;
        size--;
        return removed;
    }

    public int size() {
        return size;
    }
}
