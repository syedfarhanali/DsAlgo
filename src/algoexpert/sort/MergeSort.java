package algoexpert.sort;

import util.Utils;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{8,5,2,9,5,6,3};
        Utils.print(mergeSort(arr));

    }

    public static int[] mergeSort(int[] array) {

        if(array.length==1){
            return array;
        }

        int middle = (array.length) / 2 ;

        int[] arr1   = Arrays.copyOfRange(array,0,middle);
        int[] arr2   = Arrays.copyOfRange(array,middle,array.length);


        return mergeSortedArray(mergeSort(arr1),mergeSort(arr2));

    }

    private static int[] mergeSortedArray(int[] arr1, int[] arr2) {

        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;

        int[] result = new int[arr1.length + arr2.length];

        while(firstIndex < arr1.length && secondIndex < arr2.length){
            if(arr1[firstIndex] <= arr2[secondIndex]){
                result[resultIndex] = arr1[firstIndex];
                firstIndex++;
            }else{
                result[resultIndex] = arr2[secondIndex];
                secondIndex++;
            }
            resultIndex++;
        }

        while(firstIndex < arr1.length){
            result[resultIndex] = arr1[firstIndex];
            firstIndex++;
            resultIndex++;
        }
        while(secondIndex < arr2.length){
            result[resultIndex] = arr2[secondIndex];
            secondIndex++;
            resultIndex++;
        }

        return result;
    }
}
