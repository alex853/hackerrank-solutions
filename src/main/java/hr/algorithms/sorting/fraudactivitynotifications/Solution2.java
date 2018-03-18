package hr.algorithms.sorting.fraudactivitynotifications;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

    static int activityNotifications(int[] expenditure, int d) {
        // Complete this function

        int[] days = new int[d];

        int notifications = 0;

        for (int i = d; i < expenditure.length; i++) {
            System.arraycopy(expenditure, i-d, days, 0, d);
            Arrays.sort(days);

            int oddMedian = days[d / 2];

            int each = expenditure[i];
            if (each >= 2*oddMedian) {
                notifications++;
                System.out.println(i + " " + notifications);
            }
        }

        return notifications;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(new ByteArrayInputStream(("9 5\n" +
//                "2 3 4 2 3 6 8 4 5").getBytes()));
        Scanner in = new Scanner(Solution2.class.getResourceAsStream("/hr/sorting/fraudactivitynotifications/case2.txt"));
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();
        }
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        in.close();
    }
}
