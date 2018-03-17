package hr.algo.medium.factorialarray;

import java.util.HashMap;
import java.util.Map;

public class Factorial {
    static Map<Integer, Integer> factCache = new HashMap<>();

    public static void main(String[] args) {


        for (int i = 1; i <= 50; i++) {

            int fact = fact(i);

            System.out.println(i + "\t" + fact);

        }

    }

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
        long factModuled = factLong % 1000000000;
        int fact = (int) factModuled;

        factCache.put(n, fact);

        return fact;
    }
}
