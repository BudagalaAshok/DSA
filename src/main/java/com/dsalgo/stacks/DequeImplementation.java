package com.dsalgo.stacks;


import java.util.Scanner;

public class DequeImplementation {
    int[] deque;
    int front;
    int rear;
    int size;

    public DequeImplementation(int capacity) {
        deque = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public void pushFront(int x) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + deque.length) % deque.length;
        }
        deque[front] = x;
        size++;
    }

    public void pushBack(int x) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % deque.length;
        }
        deque[rear] = x;
        size++;
    }

    public int popFront() {
        if (isEmpty()) {
            System.out.println("Empty");
            return -1;
        }
        int popped = deque[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % deque.length;
        }
        size--;
        return popped;
    }

    public int popBack() {
        if (isEmpty()) {
            System.out.println("Empty");
            return -1;
        }
        int popped = deque[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + deque.length) % deque.length;
        }
        size--;
        return popped;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == deque.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        DequeImplementation deque = new DequeImplementation(100); // Assuming maximum capacity as 100
        for (int i = 0; i < T; i++) {
            String operation = scanner.next();
            if (operation.equals("push_front")) {
                int x = scanner.nextInt();
                deque.pushFront(x);
            } else if (operation.equals("push_back")) {
                int x = scanner.nextInt();
                deque.pushBack(x);
            } else if (operation.equals("pop_front")) {
                int popped = deque.popFront();
                if (popped != -1) {
                    System.out.println(popped);
                }
            } else if (operation.equals("pop_back")) {
                int popped = deque.popBack();
                if (popped != -1) {
                    System.out.println(popped);
                }
            }
        }
        scanner.close();
    }

}
