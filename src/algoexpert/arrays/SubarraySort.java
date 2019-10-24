package algoexpert.arrays;

import util.Utils;

public class SubarraySort {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,4,7,10,11,7,12,6,21,16,18,19};

        Utils.print(subarraySort(arr));

    }

    public static int[] subarraySort(int[] array) {

        int minMisplaced = Integer.MAX_VALUE;
        int maxMisplaced = Integer.MIN_VALUE;

        for(int i = 0; i < array.length ; i++){
            if(isMisplaced(i,array)){
                minMisplaced = Math.min(array[i],minMisplaced);
                maxMisplaced = Math.max(array[i],maxMisplaced);
            }
        }
        if(minMisplaced == Integer.MAX_VALUE && maxMisplaced == Integer.MIN_VALUE){
            return new int[]{-1,-1};
        }

        int startIndex = 0;
        int endIndex = array.length - 1;

        while(array[startIndex] <= minMisplaced){
            startIndex++;
        }
        while(array[endIndex] >= maxMisplaced){
            endIndex--;
        }

        return new int[]{startIndex,endIndex};
    }

    private static boolean isMisplaced(int i, int[] array) {
        if(i == 0){
            return array[i] > array[i+1];
        } else if(i == array.length-1){
            return array[i] < array[i-1];
        } else{
            return (array[i] > array[i+1]) || (array[i] < array[i-1]);
        }
    }

}
