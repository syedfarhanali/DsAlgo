package algoexpert.sort;

import util.Utils;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{8,5,2,9,5,6,3};

        Utils.print(insertionSort(arr));

    }

    public static int[] insertionSort(int[] array) {

        for(int i=0 ; i < array.length ; i++){
            int current = i;
            int prev = i-1;

            while (prev>=0 && array[prev] > array[current]){
                int temp = array[prev];
                array[prev] = array[current];
                array[current] = temp;
                prev--;
                current--;
            }
        }
        return array;
    }

}
