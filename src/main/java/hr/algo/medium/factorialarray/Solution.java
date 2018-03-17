package hr.algo.medium.factorialarray;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    public static void main(String[] args) {

        ByteArrayInputStream baos = new ByteArrayInputStream(("5 7\n" +
                "1 1 1 1 1\n" +
                "2 1 5\n" +
                "1 1 5\n" +
                "2 1 5\n" +
                "1 1 3\n" +
                "2 1 5\n" +
                "3 1 15\n" +
                "2 1 5").getBytes());

        Scanner in = new Scanner(baos);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < m; a0++){
            // Write Your Code Here
            int type = in.nextInt();

            switch (type) {
                case 1:
                    int l = in.nextInt();
                    int r = in.nextInt();
                    for (int i = l; i <= r; i++) {
                        A[i-1]++;
                    }
                    break;
                case 2:
                    l = in.nextInt();
                    r = in.nextInt();


                    long sum = 0;

                    for (int i = l; i <= r; i++) {
                        int Ai = A[i - 1];
                        if (Ai >= 40) {
                            continue;
                        }

                        int fact = fact(Ai);
                        sum += fact;
                    }

                    int sumModuled = (int) (sum % MODULO);

                    System.out.println(sumModuled);

                    break;
                case 3:
                    int i = in.nextInt();
                    int v = in.nextInt();
                    A[i-1] = v;
                    break;
            }
        }
        in.close();
    }

    static final int MODULO = 1000000000;

    static Map<Integer, Integer> factCache = new HashMap<>();

    private static int fact(int n) {
        Integer factCached = factCache.get(n);
        if (factCached != null) {
            return factCached;
        }

        if (n == 1) {
            return 1;
        } else if (n >= 40) {
            return 0;
        }

        long factLong = (long)fact(n - 1) * (long)n;
        long factModuled = factLong % MODULO;
        int fact = (int) factModuled;

        factCache.put(n, fact);

        return fact;
    }

}
