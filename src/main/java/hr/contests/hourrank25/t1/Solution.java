package hr.contests.hourrank25.t1;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * Created by User on 02.01.2018.
 */
public class Solution {

    static String canConstruct(int[] a) {
        // Return "Yes" or "No" denoting whether you can construct the required number.
        int sum = 0;
        for (int each : a) {
            String s = String.valueOf(each);
            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                sum += digit;
            }
        }

        boolean divisible = (sum % 3) == 0;

        return divisible ? "Yes" : "No";
    }

    public static void main(String[] args) {
        String input = "3\n" +
                "1\n" +
                "9\n" +
                "3\n" +
                "40 50 90\n" +
                "2\n" +
                "1 4";

        Scanner in = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            String result = canConstruct(a);
            System.out.println(result);
        }
        in.close();
    }

}
