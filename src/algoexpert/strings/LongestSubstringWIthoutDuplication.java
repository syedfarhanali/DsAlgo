package algoexpert.strings;

import util.Utils;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWIthoutDuplication {

    public static void main(String[] args) {

        String str = "clementisacap";
        Utils.print(longestSubstringWithoutDuplication(str));
    }

    public static String longestSubstringWithoutDuplication(String str) {

        int[] result = new int[]{0,0};

        for(int i=0 ; i < str.length() ;i++){
            Map<Character,Integer> mapping = new HashMap<>();
            mapping.put(str.charAt(i),i);
            int j = i+1;
            while(j < str.length() && mapping.get(str.charAt(j)) == null){
                mapping.put(str.charAt(j),j);
                j++;
            }
            result = getMaxArray(result, new int[]{i,j});

            if(j>=str.length()){
                break;
            }
            i = mapping.get(str.charAt(j));

        }
        return str.substring(result[0],result[1]);
    }

    public static int[] getMaxArray(int[] arr1, int[] arr2){

        if( Math.abs(arr1[1] - arr1[0]) > Math.abs(arr2[1] - arr2[0])){
            return  arr1;
        }
        return arr2;
    }
}
