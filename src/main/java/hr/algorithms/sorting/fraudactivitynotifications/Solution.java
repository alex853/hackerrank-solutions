package hr.algorithms.sorting.fraudactivitynotifications;

import java.util.*;

public class Solution {

    static int activityNotifications(int[] expenditure, int d) {
        // Complete this function
        int counts[] = new int[201];

        for (int i = 0; i < d; i++) {
            int each = expenditure[i];
            counts[each]++;
        }

        int notifications = 0;

        for (int i = d; i < expenditure.length; i++) {
            double median = computeMedian(counts, d);
            int each = expenditure[i];

            if (each >= 2*median) {
                notifications++;
                //System.out.println(i + " " + notifications);
            }

            counts[each]++;

            int leaving = expenditure[i-d];
            counts[leaving]--;
        }

        return notifications;
    }

    static double computeMedian(int counts[], int d) {
        int medianPosition = (d%2 == 1) ? d/2 : (d-1)/2;
        int position = 0;
        for (int i = 0; i < counts.length; i++) {
            int endPosition = position + counts[i] - 1;
            if (medianPosition <= endPosition) {

                if (d % 2 == 1) { // d is odd
                    return i;
                } else {
                    int a = i;
                    int b;

                    if (endPosition == medianPosition) {
                        b = a + 1;
                        while (counts[b] == 0) {
                            b++;
                        }
                    } else {
                        b = a;
                    }

                    return (a + b) / 2.0;
                }

            } else {

                position += counts[i];

            }
        }
        throw new IllegalStateException();
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(new ByteArrayInputStream(("9 5\n" +
//                "2 3 4 2 3 6 8 4 5").getBytes()));
        Scanner in = new Scanner(Solution.class.getResourceAsStream("/hr/sorting/fraudactivitynotifications/case2.txt"));
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
