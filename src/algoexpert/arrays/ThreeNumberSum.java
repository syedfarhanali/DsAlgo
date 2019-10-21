package algoexpert.arrays;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeNumberSum {

    public static void main(String[] args) {

        int[] arr = new int[]{12,3,1,2,-6,5,-8,6};
        int targetSum = 0;

        threeNumberSum(arr, targetSum);
    }

    public static ArrayList<Integer[]> threeNumberSum(int[] array, int targetSum) {

        ArrayList<Integer[]> result = new ArrayList<>();

        Arrays.sort(array);

        for(int i = 0; i < array.length-2; i++){

            int newTarget = targetSum - array[i];

            int left = i+1;
            int right = array.length-1;

            while (left < right){
                int currentSum = array[left] + array[right];
                if( currentSum == newTarget){
                    result.add(new Integer[]{array[i],array[left],array[right]});
                    left++;
                    right--;
                }else if(currentSum < newTarget){
                    left++;
                }else {
                    right--;
                }

            }


        }

        return result;
    }

}
