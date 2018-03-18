package hr.contests.worldcodesprint12.easy.salesman;

import java.util.*;

public class Solution {

    static int minimumTime(int[] x) {
        //  Return the minimum time needed to visit all the houses.
        List<Integer> list = Arrays.stream( x ).boxed().collect( java.util.stream.Collectors.toList() );
        list.sort(Integer::compare);
        int lowest = list.get(0);
        int highest = list.get(list.size() - 1);
        return highest - lowest;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] x = new int[n];
            for(int x_i = 0; x_i < n; x_i++){
                x[x_i] = in.nextInt();
            }
            int result = minimumTime(x);
            System.out.println(result);
        }
        in.close();
    }
}
