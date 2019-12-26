package algoexpert.search;

import util.Utils;

public class FindThreeLargestNumbers {

    public static void main(String[] args) {

        //int[] arr = new int[]{0,1,21,33,45,46,61,62,63,73};

        int[] arr = new int[]{-2,-1,7};



        int[] result = findThreeLargestNumbers(arr);

        Utils.print(result);

    }

    public static int[] findThreeLargestNumbers(int[] array) {

        int[] result = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};

        for(int i=0 ;i<array.length ;i++){

            int num = array[i];

            if(num > result[2]){
                result[0] = result[1];
                result[1] = result[2];
                result[2] = num;
            }else if( num > result[1]){
                result[0] = result[1];
                result[1] = num;
            }else if( num > result[0]){
                result[0] = num;
            }

        }
        return result;


    }
}
