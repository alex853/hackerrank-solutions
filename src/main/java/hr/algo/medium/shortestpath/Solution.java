package hr.algo.medium.shortestpath;

import java.util.Scanner;

public class Solution {

    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        //  Print the distance along with the sequence of moves.

        int dx = j_start - j_end;
        int dy = i_start - i_end;

        boolean impossible = false;

        int nc = dy / 2;
        impossible |= (dy != nc * 2);

        if (impossible) {
            System.out.println("Impossible");
            return;
        }

        boolean difficalCase;
        int nh;

        if (Math.abs(dx) < Math.abs(nc)) {
            difficalCase = true;

            boolean dx_odd = dx % 2 == 0;
            boolean nc_odd = nc % 2 == 0;

            impossible = dx_odd == nc_odd;

            nh = 0;
        } else {
            difficalCase = false;

            nh = (dx - nc) / 2;
            impossible |= (dx != nc + 2 * nh);
        }

        if (impossible) {
            System.out.println("Impossible");
            return;
        }

        System.out.println(Math.abs(nc) + Math.abs(nh));
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();*/

        printShortestPath(7, 6, 6, 0, 1);
        printShortestPath(6, 5, 1, 0, 5);
        printShortestPath(7, 0, 3, 4, 3);
    }
}
