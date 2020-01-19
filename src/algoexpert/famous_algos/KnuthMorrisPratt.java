package algoexpert.famous_algos;

import java.util.Arrays;

public class KnuthMorrisPratt {

    public static void main(String[] args) {

        String str = "aefcdfaecdaefaefcdaefeaefcdcdeae";
        String substr = "aefcdaefeaefcd";
        System.out.println(knuthMorrisPrattAlgorithm(str,substr));

    }

    public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {

        int[] parsed = buildPattern(substring);

        return searchSubstring(string,substring,parsed);

    }

    private static boolean searchSubstring(String string, String substring, int[] parsed) {

        int strIdx = 0;
        int subIdx = 0;
        char[] str = string.toCharArray();
        char[] subStr = substring.toCharArray();

        while( strIdx < str.length && subIdx < subStr.length){
            if(str[strIdx] == subStr[subIdx]){
                strIdx++;
                subIdx++;
            }else{
                if(subIdx>0){
                    subIdx = parsed[subIdx-1] + 1;
                }else{
                    strIdx++;
                }
            }
        }
        if(subIdx == subStr.length){
            return true;
        }
        return false;
    }

    private static int[] buildPattern(String substring) {

        int i = 0;
        int j = 1;
        int[] result = new int[substring.length()];
        Arrays.fill(result,-1);
        char[] str = substring.toCharArray();

        while(j < str.length){
            if(str[i] == str[j]){
                result[j] = i;
                i++;
                j++;
            }else{
               if(i>0){
                    i = result[i-1] +1;
               }else{
                   j++;
               }
            }
        }
        return result;
    }


}
