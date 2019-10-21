package algoexpert.dynamicProgramming;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String str1 = "ZXVVYZW";
        String str2 = "XKYKZPW";

        Utils.print(longestCommonSubsequence(str1,str2));
    }

    public static ArrayList<Character> longestCommonSubsequence(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();


        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        for(int i=0 ; i < chars1.length; i++){
            ArrayList<String> row = new ArrayList<String>();
            for(int j=0; j<chars2.length ; j++){
                row.add(j,"");
                result.add(row);
            }
        }

        for(int i=1 ; i < chars1.length + 1; i++){
            ArrayList<String> row = result.get(i-1);
            for(int j=1; j<chars2.length + 1; j++){
                if(chars1[i-1] == chars2[j-1]){
                    String lcs = result.get(i-1).get(j-1);
                    lcs = lcs + chars1[i-1];
                    row.add(j-1,lcs);
                }else{
                    String topStr = result.get(i).get(j-1);
                    String leftStr = result.get(i-1).get(j);
                    String lcs = topStr.length() > leftStr.length() ? topStr : leftStr;
                    row.add(j-1,lcs);
                }
            }
            result.add(i-1,row);
        }

        ArrayList<Character> resultChar  = (ArrayList) result.get(chars1.length-1).get(chars2.length-1).chars().mapToObj(e -> (char) e).collect(Collectors.toList());;

        return resultChar;
    }

}
