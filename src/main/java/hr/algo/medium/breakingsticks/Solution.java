package hr.algo.medium.breakingsticks;

import java.util.Date;

public class Solution {

    static long longestSequence(long[] a) {
        //  Return the length of the longest possible sequence of moves.
        long sum = 0;
        for (long each : a) {
            sum += eatOrSplit(each);
        }
        return sum;
    }

    private static long eatOrSplit(long length) {
        if (length == 1) {
            return 1; // eat it
        }



        long newStickLength = maxDivider_bruteforce(length);
        long newStickCount = length / newStickLength;

        return newStickCount * eatOrSplit(newStickLength) + 1;
    }

    private static long minDivider_bruteforce(long n) {
        for (long i = 2; i <= n/2; i++) {
            long remainder = n % i;
            if (remainder == 0) {
                return i;
            }
        }
        return 1;
    }

    private static long maxDivider_bruteforce(long n) {
        long start = n/2;
        for (long i = start; i >= 1; i--) {
            long remainder = n % i;
            if (remainder == 0) {
                return i;
            }
        }
        return 1;
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



        check(longestSequence(new long[] {1L}), 1);
        check(longestSequence(new long[] {6L}), 10);
        check(longestSequence(new long[] {7L}), 8);
        check(longestSequence(new long[] {15L}), 21);
        check(longestSequence(new long[] {24L}), 46);
        check(longestSequence(new long[] {100L}), 181);


        check(longestSequence(new long[] {1L, 7L, 24L}), 55);

        System.out.println(new Date());
        System.out.println(longestSequence(new long[] {112364342349L}));
        System.out.println(new Date());
    }

    private static void check(long actual, long expected) {
        System.out.println("Expected " + expected + "\t\tactual " + actual + "\t\t" + (expected == actual ? "ok" : "FAIL"));
    }
}
