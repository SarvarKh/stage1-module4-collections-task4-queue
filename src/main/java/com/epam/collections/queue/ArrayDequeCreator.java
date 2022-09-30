package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public static void main(String[] args) {
        ArrayDequeCreator deque = new ArrayDequeCreator();
        Queue<Integer> firstQ = new LinkedList<>(List.of(1, 3, 5, 4, 7, 9));
        Queue<Integer> secondQ = new LinkedList<>(List.of(4, 2, 8, 5, 8, 3));
        deque.createArrayDeque(firstQ, secondQ);
    }
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(firstQueue.remove());
        deque.add(firstQueue.remove());
        deque.add(secondQueue.remove());
        deque.add(secondQueue.remove());

        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            firstQueue.add(deque.removeLast());
            deque.add(firstQueue.remove());
            deque.add(firstQueue.remove());

            secondQueue.add(deque.removeLast());
            deque.add(secondQueue.remove());
            deque.add(secondQueue.remove());
        }

        return deque;
    }
}
