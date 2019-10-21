package algoexpert.arrays;

import util.Utils;

import java.util.Arrays;
import java.util.HashMap;

public class TwoNumberSum {

    public static void main(String[] args) {

        int[] arr = new int[]{3,5,-4,8,11,1,-1,6};
        int targetSum = 10;

        Utils.print(twoNumberSum(arr,targetSum));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {

        HashMap<Integer,Boolean> compliment = new HashMap<>();

        if(array.length < 2){
            return new int[]{};
        }

        for(int i = 0; i<array.length ; i++){

            int num = array[i];
            int numcom = targetSum - num;

            if(compliment.get(numcom) != null){
                int[] result = new int[]{num,numcom};
                Arrays.sort(result);
                return result;
            }else{
                compliment.put(num,true);
            }

        }
        return new int[]{};

    }
}
