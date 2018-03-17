package hr.algo;

import java.util.Arrays;

/**
 * Created by User on 19.12.2017.
 */
public class b1 {
    public static void main(String[] args) {
        insertIntoSorted(new int[] {3, 4, 5, 6, 7, 8, 2});
    }

    public static void insertIntoSorted(int[] ar) {
        // Fill up this function
        int v = ar[ar.length-1];

        int j = ar.length-1;
        while (j > 0 && ar[j-1] > v) {
            ar[j] = ar[j-1];
            printArray(ar);
            j--;
        }

        ar[j] = v;
        printArray(ar);
    }



    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

}
