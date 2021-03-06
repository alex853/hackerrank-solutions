package hr.contests.hourrank25.t2;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * Created by User on 02.01.2018.
 */
public class Solution {

    private static String s;

    static void initialize(String s) {
        // This function is called once before all queries.
        Solution.s = s;
    }

    static int answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
        String s = Solution.s.substring(l - 1, r);
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            counts[index]++;
        }

        int pairs = 0;
        int notPaired = 0;
        for (int i = 0; i < 26; i++) {
            int count = counts[i];
            pairs += count / 2;
            notPaired += count % 2;
        }

        if (notPaired == 0) {
            return factor007(pairs);
        } else {
            return mult007(notPaired, factor007(pairs));
        }
    }

    static int mult007(int a, int b) {
        long r = (long) a * (long) b;
        r = r % 1000000007;
        return (int) r;
    }

    static int factor007(int n) {
        int r = 1;
        for (int i = 1; i <= n; i++) {
            r = mult007(r, i);
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new ByteArrayInputStream(("week\n"+
                "2\n"+
                "1 4\n"+
                "2 3").getBytes()));
//        Scanner in = new Scanner(new ByteArrayInputStream(("abab\n" +
//                "1\n" +
//                "1 4").getBytes()));
        String s = in.next();
        initialize(s);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int l = in.nextInt();
            int r = in.nextInt();
            int result = answerQuery(l, r);
            System.out.println(result);
        }
        in.close();
    }
}
