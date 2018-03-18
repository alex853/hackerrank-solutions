package hr.algorithms.search.missingnumbers;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * Created by Alexey on 09.02.2018.
 */
public class Solution {
    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> aMap = new TreeMap<>();
        Map<Integer, Integer> bMap = new TreeMap<>();

        for (int a : arr) {
            Integer freq = aMap.get(a);
            freq = freq != null ? freq+1 : 1;
            aMap.put(a, freq);
        }

        for (int b : brr) {
            Integer freq = bMap.get(b);
            freq = freq != null ? freq+1 : 1;
            bMap.put(b, freq);
        }

        List<Integer> result = new ArrayList<>();
        for (int b : bMap.keySet()) {
            Integer bFreq = bMap.get(b);
            Integer aFreq = aMap.get(b);

            if (aFreq == null || bFreq > aFreq) {
                result.add(b);
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new ByteArrayInputStream(("10\n" +
                "203 204 205 206 207 208 203 204 205 206\n" +
                "13\n" +
                "203 204 204 205 206 207 205 208 203 206 205 206 204").getBytes()));
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }
        int[] result = missingNumbers(arr, brr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }

}
