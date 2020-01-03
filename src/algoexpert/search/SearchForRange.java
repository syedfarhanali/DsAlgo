package algoexpert.search;

import util.Utils;

public class SearchForRange {

    public static void main(String[] args) {

        //int[] arr = new int[]{0,1,21,33,45,45,45,45,45,45,61,71,73};
        int[] arr = new int[]{5,7,7,8,8,10};

        Utils.print(searchForRange(arr, 7));

    }

    public static int[] searchForRange(int[] array, int target) {

        int start = searchForBoundaries(array,target,true);
        int end = searchForBoundaries(array,target,false);

        return new int[]{start,end};
    }

    public static int searchForBoundaries(int[] array, int target, boolean start){

        int left = 0;
        int right = array.length - 1;


        int result;

        while(left <= right){
            int middle = (left + right) / 2;

            if(array[middle] == target){
                result = middle;

                if (middle == 0 || middle == array.length-1) {
                    return result;
                }if( (start && array[middle -1] != target) || (!start && array[middle+1] != target) ){
                    return result;
                }
                if(start){
                    right = middle -1;
                }else{
                    left = middle+1;
                }

            }else if(target < array[middle]){
                right = middle -1;
            }else {
                left = middle +1 ;
            }
        }

        return -1;
    }
}
