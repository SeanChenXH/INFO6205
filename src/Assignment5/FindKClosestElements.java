package Assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 658. Find K Closest Elements
 * <p>
 * Given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x in the array. The result should also be sorted in ascending order.
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Math.abs(a - x) == Math.abs(b - x) ? b - a : Math.abs(b - x) - Math.abs(a - x));

        for (int i : arr) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }

        Collections.sort(list);
        return list;
    }
}
