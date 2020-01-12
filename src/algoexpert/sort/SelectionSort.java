package algoexpert.sort;

import util.Utils;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{8,5,2,9,5,6,3};
        Utils.print(selectionSort(arr));

    }

    public static int[] selectionSort(int[] array) {
        for(int i=0 ; i< array.length ; i++){
            int min = i;
            for(int j=i+1 ; j< array.length ;j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
