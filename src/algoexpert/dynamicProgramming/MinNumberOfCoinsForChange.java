package algoexpert.dynamicProgramming;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    public static void main(String[] args) {

        int[] denoms = new int[]{2,3};
        int target = 10;

        System.out.println(minNumberOfCoinsForChange(target, denoms));

    }


    public static int minNumberOfCoinsForChange(int n, int[] denoms) {

        Arrays.sort(denoms);

        if(n == 0){
            return -1;
        }
        int[] ways = new int[n+1];
        Arrays.fill(ways,Integer.MAX_VALUE);
        ways[0] = 0;

        for(int i = 0 ; i <denoms.length ; i++){

            for(int j=0 ; j < ways.length ; j++){

                if(denoms[i] <= j){
                    ways[j] =  Math.min(ways[j], 1 + ways[ j - denoms[i] ]);
                }

            }

        }

        if(ways[n] == Integer.MAX_VALUE){
            return -1;
        }
        return ways[n];
    }
}
