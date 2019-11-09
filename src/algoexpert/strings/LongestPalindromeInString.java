package algoexpert.strings;

import java.util.stream.IntStream;

public class LongestPalindromeInString {

    public static void main(String[] args) {

        String str = "abaxyzzyxf";
        System.out.println(longestPalindromicSubstring(str));
    }


    public static String longestPalindromicSubstring(String str) {

        int[] longestPalindrome = new int[2];
        for(int i = 1; i < str.length() ;i++){
            int[] odd = getLongestPalindromeStartingFrom(str,i-1, i+1);
            int[] even = getLongestPalindromeStartingFrom(str,i-1, i);

            int[] currentMax = getMaxArray(odd,even);
            longestPalindrome  = getMaxArray(currentMax,longestPalindrome);

        }
        return str.substring(longestPalindrome[0],longestPalindrome[1]+1);
    }

    public static int[] getLongestPalindromeStartingFrom(String str, int left, int right) {
        int[] result = new int[2];
        while(left >=0 && right < str.length()){
            if(str.charAt(left) == str.charAt(right)){
                result[0] = left;
                result[1] = right;
                left--;
                right ++;
            }else{
                break;
            }
        }
       return result;
    }

    public static int[] getMaxArray(int[] arr1, int[] arr2){

        if( Math.abs(arr1[1] - arr1[0]) > Math.abs(arr2[1] - arr2[0])){
            return  arr1;
        }
        return arr2;
    }




}
