package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueCreator {
    public static void main(String[] args) {
        List<String> l1 = List.of("The", "Java", "PriorityQueue", "class");
        List<String> l2 = List.of("Objects", "are", "processed", "based", "on", "their", "priority");
        PriorityQueueCreator p = new PriorityQueueCreator();
        p.createPriorityQueue(l1, l2);
    }
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        PriorityQueue<String> result = new PriorityQueue<>(11, new stringComparator());
        if (firstList.size() == 0 && secondList.size() == 0) return result;

        List<String> mergedList = new ArrayList<>();
        mergedList.addAll(firstList);
        mergedList.addAll(secondList);

        for (String item : mergedList) {
            result.add(item);
        }
        return result;
    }
}

class stringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.compareTo(o2) < 0) {
            return 1;
        } else if (o1.compareTo(o2) > 0) {
            return -1;
        }
        return 0;
    }
}
