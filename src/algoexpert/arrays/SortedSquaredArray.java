package algoexpert.arrays;

import util.Utils;

public class SortedSquaredArray {
    public static int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];

        for(int i=0 ; i < array.length ; i++){
            int num = array[i] * array[i];
            result[i] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        Utils.print(sortedSquaredArray(arr));
    }

}
