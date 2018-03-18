package hr.algorithms.sorting.insertionAdv;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;

/**
 * Created by Alexey on 04.02.2018.
 */
public class Solution {

    public static long insertionSort(int[] arr) {
        int maxElement = 10000000; // according to the problem statement
        long[] BIT = new long[maxElement+1];

        long invCount = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            invCount += getBITSum(BIT, arr[i]-1);

            updateBIT(BIT, arr[i], 1);
        }
        return invCount;
    }

    private static long getBITSum(long[] BIT, int index) {
        int sum = 0; // Initialize result

        // Traverse ancestors of BITree[index]
        while (index > 0) {
            // Add current element of BITree to sum
            sum += BIT[index];

            // Move index to parent node in getSum View
            index -= index & (-index);
        }
        return sum;
    }

    private static void updateBIT(long[] BIT, int index, int val) {
        // Traverse all ancestors and add 'val'
        while (index < BIT.length) {
            // Add 'val' to current node of BI Tree
            BIT[index] += val;

            // Update index to that of parent in update View
            index += index & (-index);
        }
    }

    public static long insertionSort1(int[] arr) {
        long shifts = 0;
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > v) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = v;
            shifts += (i-j);
        }
        return shifts;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new ByteArrayInputStream(("6\n" +
                "1 4 3 5 6 2").getBytes()));
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}
