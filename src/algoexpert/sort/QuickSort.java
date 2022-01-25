package algoexpert.sort;

import util.Utils;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8,5,2,9,5,6,3};
        Utils.print(quickSort(arr));
    }

    public static int[] quickSort(int[] array) {


        return  quickSort1(array,0,array.length);

    }

    public static int[] quickSort(int[] array,int start, int end) {

        if(start >= end-1){
            return array;
        }
        int pivot = start;
        int left = start + 1;
        int right = end-1;


        while(left <= right && (right>start && left < end)){

            if(array[left] >  array[pivot] && array[right] < array[pivot]){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

            if(array[left] <= array[pivot]){
                left++;
            }

            if(array[right] >= array[pivot]){
                right--;
            }


        }

        int temp = array[right];
        array[right] = array[pivot];
        array[pivot] = temp;

        quickSort(array,start,right);
        quickSort(array,right+1,array.length);

        return array;
    }


    public static int[] quickSort1(int[] array, int start, int end){

        if(start >= end-1) {
            return array;
        }
        System.out.println(start+"**"+end);
        int pivot = start;
        int left = start + 1;
        int right = end - 1;

        while(left <= right && (right>start && left<end)){
            if(array[pivot] < array[left] && array[pivot] > array[right] ){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            if(array[left] < array[pivot]){
                left++;
            }
            if(array[right] >= array[pivot]){
                right--;
            }
        }

        int temp = array[right];
        array[right] = array[pivot];
        array[pivot] = temp;

        quickSort1(array,start, right);
        quickSort1(array,right+1, array.length);

        return array;

    }
}
