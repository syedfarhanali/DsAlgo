package algoexpert.arrays;

import util.Utils;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {

        int[] a1 = new int[]{-1,5,10,20,28,3,50};
        int[] a2 = new int[]{26,134,135,15,17};

        Utils.print(smallestDifference(a1,a2));

    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {


        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int i = 0;
        int j = 0;
        int resArrayOne = 0;
        int resArrayTwo = 0;
        int minDiff = Integer.MAX_VALUE;

        while(i< arrayOne.length && j< arrayTwo.length){

            int diff = Math.abs(arrayOne[i]- arrayTwo[j]);


            if(diff < minDiff){
                minDiff = diff;
                resArrayOne = i;
                resArrayTwo = j;
            }

            if(arrayOne[i] == arrayTwo[j]){
                return new int[]{arrayOne[i],arrayTwo[j]};
            } else if(arrayOne[i] < arrayTwo[j]){
                i++;
            }else{
                j++;
            }

        }
        return new int[]{arrayOne[resArrayOne],arrayTwo[resArrayTwo]};

    };



}
