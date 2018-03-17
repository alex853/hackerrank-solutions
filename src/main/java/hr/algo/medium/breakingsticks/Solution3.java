package hr.algo.medium.breakingsticks;

import java.util.*;

public class Solution3 {

    static boolean[] isPrime;
    static Map<Long, Long> cache = new HashMap<>();

    static long longestSequence(long[] a) {
        //  Return the length of the longest possible sequence of moves.

        if (isPrime == null) {
            isPrime = new boolean[1000001];

            for (int i = 0; i < 1000000; i++) {
                isPrime[i] = true;
            }

            //mark non-primes <=N using Sieve of Eratosthenes
            for (int i = 2; i * i <= 1000000; i++) {
                //if is a prime, then mark multiples of i as non prime
                for (int j = i; i * j <= 1000000; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        long sum = 0;
        for (long each : a) {
            sum += eatOrSplit(each);
        }
        return sum;
    }

    private static int[] factorize(long n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                continue;
            }

            int prime = i;

            long remainder = n % prime;
            while (remainder == 0 && n > 1) {
                result.add(prime);
                n = n / prime;
                remainder = n % prime;
            }
        }

        return toIntArray(result);
    }

    private static long eatOrSplit(long size) {
        Long cachedResult = cache.get(size);
        if (cachedResult != null) {
            return cachedResult;
        }

        if (size == 1) {
            cache.put(size, 1L);
            return 1; // eat it
        }

        long bestSum = 1 + size;

        int[] f = factorize(size);

        /*for (long i = 2; i <= Math.sqrt(size); i++) {
            if (size % i != 0) {
                continue;
            }

            long currCount = i;
            long currSize = size / currCount;
            long currSum = currCount * eatOrSplit(currSize) + 1;
            if (currSum > bestSum) {
                bestSum = currSum;
            }

            currSize = i;
            currCount = size / currSize;
            currSum = currCount * eatOrSplit(currSize) + 1;
            if (currSum > bestSum) {
                bestSum = currSum;
            }
        }*/

        cache.put(size, bestSum);
        return bestSum;
    }

    private static int[] toIntArray(List<Integer> b) {
        int[] result = new int[b.size()];
        for (int i = 0; i < b.size(); i++) {
            result[i] = b.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextLong();
        }
        long result = longestSequence(a);
        System.out.println(result);
        in.close();*/


        check(longestSequence(new long[]{1L}), 1);
        check(longestSequence(new long[]{2L}), 3);
        check(longestSequence(new long[]{3L}), 4);
        check(longestSequence(new long[]{4L}), 7);
        check(longestSequence(new long[]{5L}), 6);
        check(longestSequence(new long[]{6L}), 10);
        check(longestSequence(new long[]{7L}), 8);
        check(longestSequence(new long[]{15L}), 21);
        check(longestSequence(new long[]{24L}), 46);
        check(longestSequence(new long[]{100L}), 181);

        check(longestSequence(new long[]{1L, 7L, 24L}), 55);

        System.out.println(new Date());
        System.out.println(longestSequence(new long[]{112364342349L}));
        System.out.println(new Date());
        for (int i = 1; i <= 100; i++) {
            System.out.println(longestSequence(new long[]{9999990000001L}));
        }
        System.out.println(new Date());
    }

    private static void check(long actual, long expected) {
        System.out.println("Expected " + expected + "\t\tactual " + actual + "\t\t" + (expected == actual ? "ok" : "FAIL"));
    }
}
