package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Utils {

    public static void print2D(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {         //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) {   //this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }

    public static void print(Integer arrayInt[]) {
        System.out.println(java.util.Arrays.toString(arrayInt));
    }
    public static void print(int arrayInt[]) {

        System.out.println(java.util.Arrays.toString(arrayInt));

    }

    public static void print(Integer a) {
        System.out.println(a);
    }


    public static void print(ArrayList<Character> longestCommonSubsequence) {
        String string =  longestCommonSubsequence.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(string);
    }

    public static void print(int[][] values) {
        for (int[] row : values)
            System.out.println(Arrays.toString(row));
    }




}
