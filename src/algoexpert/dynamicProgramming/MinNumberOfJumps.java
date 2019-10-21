package algoexpert.dynamicProgramming;

import java.util.Arrays;

public class MinNumberOfJumps {

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,2,3,7,1,1,1,3};
        System.out.println(minNumberOfJumps(array));
    }

    public static int minNumberOfJumps(int[] array) {

        int[] jumps = new int[array.length];
        Arrays.fill(jumps,Integer.MAX_VALUE);

        jumps[0] = 0;

        for(int i=1; i< array.length ; i++){

            for(int j=0 ; j<i ; j++){

                if(j + array[j] >= i){

                    if( jumps[i] > jumps[j] + 1){

                        jumps[i] = jumps[j] + 1;

                    }

                }

            }
        }
       return jumps[array.length-1];
    }
}
