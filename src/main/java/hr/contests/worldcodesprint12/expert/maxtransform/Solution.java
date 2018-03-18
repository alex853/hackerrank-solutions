package hr.contests.worldcodesprint12.expert.maxtransform;

import java.util.*;

public class Solution {

    static int solve(int[] A) {
        //  Return the length of the longest possible sequence of moves modulo 10^9+7.

        maxCache.clear();

        int[] s1 = maxTransform(A);
        int[] s2 = maxTransform(s1);

        int sum = 0;
        int modulo = 10^9 + 7;
        for (int each : s2) {
            each = each % modulo;
            sum += each;
        }

        return sum;
    }

    private static int[] maxTransform(int[] A) {
        List<Integer> B = new ArrayList<>();

        for (int k = 0; k < A.length; k++) {
            System.out.print("k=" + k + "\t");
            for (int i = 0; i < A.length - k; i++) {
                int j = i + k;
                int max = max(A, i, j);
                B.add(max);
                System.out.print(max + "\t");
            }
            System.out.println();
        }

        System.out.println();

        return toIntArray(B);
    }

    static Map<String, Integer> maxCache = new HashMap<>();

    private static int max(int[] A, int i, int j) {
        String key = i + ":" + j;
        Integer cached = maxCache.get(key);
        if (cached != null) {
            return cached;
        }

        int max = A[i];
        for ( ; i <= j; i++) {
            max = A[i] > max ? A[i] : max;
        }

        maxCache.put(key, max);
        return max;
    }

    private static int[] toIntArray(List<Integer> b) {
        int[] result = new int[b.size()];
        for (int i = 0; i < b.size(); i++) {
            result[i] = b.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = solve(a);
        System.out.println(result);
        in.close();*/

        System.out.println(solve(new int[] {3, 2, 1}));
        System.out.println(solve(new int[] {10, 7, 4, 8, 6, 9, 5, 11}));
    }
}