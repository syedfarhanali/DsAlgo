package algoexpert.dynamicProgramming;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {

        int[] arr = new int[]{8,12,2,3,15,5,7};
        System.out.println(maxSumIncreasingSubsequence(arr));


    }

    public static ArrayList<ArrayList<Integer>> maxSumIncreasingSubsequence(int[] array) {
            // Write your code here.

        int[] sums = array.clone();
        Integer[] index = new Integer[array.length];

        int maxSum =  array[0];
        int maxIndex = 0;
        index[0] = null;

        for(int i=1 ; i< array.length ;i++){
            for(int j = 0 ; j<i ; j++){
                if(array[i] > array[j]){
                    int currentSum = sums[j] + array[i];
                    if (currentSum > sums[i]){
                        sums[i] = currentSum;
                        index[i] = j;
                        if(currentSum > maxSum){
                            maxSum = currentSum;
                            maxIndex = i;
                        }
                    }else if(array[i] >= currentSum){
                        index[i] = null;
                        if(sums[i] > maxSum){
                            maxSum = sums[i];
                            maxIndex = i;
                        }
                    }
                }
            }
        }

        //Utils.print(sums);
        //Utils.print(maxSum);
        //Utils.print(maxIndex);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        ArrayList sequence = new ArrayList<Integer>();
        sequence.add(array[maxIndex]);

        while(index[maxIndex] != null){
            sequence.add(array[index[maxIndex]]);
            maxIndex = index[maxIndex];
        }
        Collections.reverse(sequence);

        ArrayList max = new ArrayList<Integer>();
        max.add(maxSum);
        result.add(max);

        result.add(sequence);
        return result ;
    }


}
