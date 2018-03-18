package hr.algorithms.search.rednightsshortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static final int Impossible = -1;
    // UL, UR, R, LR, LL, L
    public static final int UL = 0;
    public static final int UR = 1;
    public static final int R  = 2;
    public static final int LR = 3;
    public static final int LL = 4;
    public static final int L  = 5;
    public static final String[] Moves = {"UL", "UR", "R", "LR", "LL", "L"};

    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        int[] results = findShortestPath(n, i_start, j_start, i_end, j_end);

        if (results[0] == Impossible) {
            System.out.println("Impossible");
            return;
        }

        System.out.println(results[0]); // moves count
        for (int i = 1; i < results.length; i++) {
            System.out.print(Moves[results[i]] + " ");
        }
        System.out.println();
    }

    static int[] findShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        int dj = j_end - j_start;
        int di = i_end - i_start;

        if (di % 2 != 0) {
            return new int[] {Impossible};
        }

        int AplusB = di / 2;
        int AplusBsign = AplusB > 0 ? 1 : -1;

        List<int[]> solutions = new ArrayList<>();

        int minLength = Integer.MAX_VALUE;
        for (int i = Math.abs(AplusB); i >= 0; i--) {
            int a = AplusBsign * i;
            int b = AplusB - a;

            int h2 = dj - a + b;
            if (h2 % 2 != 0) {
                continue;
            }
            int h = h2 / 2;

            int length = Math.abs(a) + Math.abs(b) + Math.abs(h);
            if (length < minLength) {
                minLength = length;
                solutions.clear();
            }

            if (length > minLength) {
                continue;
            }

            solutions.add(new int[] {a, b, h, length});
        }

        if (solutions.isEmpty()) {
            return new int[] {Impossible};
        }

        int[] solution = solutions.get(0);

        int ul_lr = solution[0];
        int ul_lr_move = ul_lr < 0 ? UL : LR;
        ul_lr = Math.abs(ul_lr);

        int ur_ll = solution[1];
        int ur_ll_move = ur_ll < 0 ? UR : LL;
        ur_ll = Math.abs(ur_ll);

        int r_l = solution[2];
        int r_l_move = r_l < 0 ? L : R;
        r_l = Math.abs(r_l);

        int length = ul_lr + ur_ll + r_l;
        int[] moves = new int[length+1];

        int index = 1;

        for (int i = 0; i < ul_lr; i++, index++) {
            moves[index] = ul_lr_move;
        }

        for (int i = 0; i < ur_ll; i++, index++) {
            moves[index] = ur_ll_move;
        }

        for (int i = 0; i < r_l; i++, index++) {
            moves[index] = r_l_move;
        }

        Arrays.sort(moves); // ugly hack
        moves[0] = length;

        return moves;
    }

    static int[] findShortestPath_old(int n, int i_start, int j_start, int i_end, int j_end) {
        //  Print the distance along with the sequence of moves.

        int dx = j_start - j_end;
        int dy = i_start - i_end;

        boolean impossible = false;

        int nc = dy / 2;

        if (dy % 2 != 0) {
            return new int[]{Impossible};
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
            return new int[]{Impossible};
        }

        return new int[]{Math.abs(nc) + Math.abs(nh)};
    }
}
