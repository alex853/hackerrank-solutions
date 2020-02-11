package hr.datastructures.heap.find_the_running_median;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    static double[] runningMedian(int[] a) {
        double[] result = new double[a.length];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < a.length; i++) {
            int each = a[i];
            boolean isEmpty = minHeap.isEmpty() && maxHeap.isEmpty();
            if (isEmpty) {
                minHeap.add(each);
            } else {
                double median = median(minHeap, maxHeap);
                if (each <= median) {
                    maxHeap.add(each);
                } else {
                    minHeap.add(each);
                }
            }

            if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                } else {
                    maxHeap.add(minHeap.poll());
                }
            }

//            System.out.println(median(minHeap, maxHeap));
//            System.out.println("maxHeap = " + maxHeap);
//            System.out.println("minHeap = " + minHeap);
            result[i] = median(minHeap, maxHeap);
        }

        return result;
    }

    private static double median(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
        }

        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        } else {
            return (double) minHeap.peek();
        }
    }

    public static void main(String[] args) {
        runningMedian(new int[]{12,
                4,
                5,
                3,
                8,
                7});
    }

}
