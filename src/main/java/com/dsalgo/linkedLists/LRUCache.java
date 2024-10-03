package com.dsalgo.linkedLists;

import java.util.*;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> map;
    private final DoublyLinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            dll.moveToHead(node); // Move the accessed node to the head (most recently used)
            return node.value;
        }
        return -1; // Key not found
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value; // Update the value
            dll.moveToHead(node); // Move to the head as it's now most recently used
        } else {
            if (map.size() == capacity) {
                Node tail = dll.removeTail(); // Remove the least recently used item
                map.remove(tail.key); // Remove it from the map as well
            }
            Node newNode = new Node(key, value);
            dll.addNode(newNode); // Add new node to the front
            map.put(key, newNode); // Add to the map
        }
    }

    // Node class to represent the doubly linked list nodes
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Doubly linked list to keep track of the order of nodes
    private static class DoublyLinkedList {
        private final Node head;
        private final Node tail;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addNode(Node node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        void removeNode(Node node) {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        void moveToHead(Node node) {
            removeNode(node);
            addNode(node);
        }

        Node removeTail() {
            Node node = tail.prev;
            removeNode(node);
            return node;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));    // returns 1
        cache.put(3, 3);                     // evicts key 2
        System.out.println(cache.get(2));    // returns -1 (not found)
        cache.put(4, 4);                     // evicts key 1
        System.out.println(cache.get(1));    // returns -1 (not found)
        System.out.println(cache.get(3));    // returns 3
        System.out.println(cache.get(4));    // returns 4
    }
}
