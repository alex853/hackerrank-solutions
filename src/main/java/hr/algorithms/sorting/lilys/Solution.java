package hr.algorithms.sorting.lilys;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Alexey on 04.02.2018.
 */
public class Solution {
    static int lilysHomework(int[] arr) {
        int r1 = doJob(arr);

        // reverting an array
        for (int i = 0; i < arr.length / 2; i++) {
            int t = arr[i];
            arr[i] = arr[arr.length-1 - i];
            arr[arr.length-1 - i] = t;
        }

        int r2 = doJob(arr);

        return Math.min(r1, r2);
    }

    static int doJob(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        arr = copy;

        int[] sorted = new int[arr.length];
        System.arraycopy(arr, 0, sorted, 0, arr.length);
        Arrays.sort(sorted);

        Map<Integer, Integer> value2index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            value2index.put(value, i);
        }

        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            int arr_i = arr[i];
            int sorted_i = sorted[i];

            if (arr_i == sorted_i) {
                continue;
            }

            int mapIndex = value2index.get(sorted_i);
            value2index.put(arr_i, mapIndex);
            arr[i] = sorted_i;
            arr[mapIndex] = arr_i;

            swaps++;
        }

        return swaps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new ByteArrayInputStream(("4\n" +
                "2 5 3 1").getBytes()));
//        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = lilysHomework(arr);
        System.out.println(result);
        in.close();
    }

}
