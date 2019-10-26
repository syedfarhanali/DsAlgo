package algoexpert.arrays;


import util.Utils;

import java.util.Hashtable;
import java.util.Map;

public class LargestRange {

    public static void main(String[] args) {

        int[] arr = new int[]{1,11,3,0,15,5,2,4,10,7,12,6};

        Utils.print(largestRange(arr));

    }

    // One solution is to sort the array and then find the largest range

    public static int[] largestRange(int[] array) {

        Map<Integer,Boolean> map = new Hashtable<>();

        for(int i=0 ;i < array.length ;i++){
            map.put(array[i],Boolean.TRUE);
        }

        Integer minNum = 0;
        Integer maxNum = 0;
        Integer maxRange = Integer.MIN_VALUE;



        for(int i=0 ;i < array.length ;i++){

            int num = array[i];
            Integer currentRange = 0;

            if(map.get(num) == Boolean.FALSE){
                continue;
            }

            int j = num+1;//8
            while(map.get(j) != null){
                map.put(j,Boolean.FALSE);
                currentRange++;
                j++;
            }

            int k = num-1; //-1
            while(map.get(k) != null){
                map.put(k,Boolean.FALSE);
                currentRange++;
                k--;
            }

            if(currentRange > maxRange){
                maxRange = currentRange;
                minNum = k+1;
                maxNum = j-1;
            }


        }

        return new int[]{minNum,maxNum};

    }
}
