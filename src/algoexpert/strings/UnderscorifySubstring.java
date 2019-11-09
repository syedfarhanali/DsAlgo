package algoexpert.strings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UnderscorifySubstring {

    public static void main(String[] args) {

        String str = "abcd test test asad testtest tetasds test";
        String subString = "test";
        System.out.println(underscorifySubstring(str,subString));
    }

    public static String underscorifySubstring(String str, String substring) {

        List<Integer[]> allMatches = new ArrayList<>();
        Integer[] matches = new Integer[2];
        int i = 0;

        while(i <= str.length()-substring.length()){
            matches = checkIfNextSubstringMatches(i,str,substring);
            if(matches[1] != null ){
                i = matches[1]+1;
                allMatches.add(matches);
            }else {
                i++;
            }
        }
        return addUnderscore(allMatches,str);
    }

    private static String addUnderscore(List<Integer[]> allMatches, String str) {

        char[] result = new char[str.length()+allMatches.size()*2];

        List<Integer> underscoreList = allMatches.stream().flatMap(x-> Arrays.stream(x)).collect(Collectors.toList());
        char[] resultArr = new char[str.length() + underscoreList.size()];

        Integer iterator = 0;
        Integer insertPosition = 0;
        for (char c :  str.toCharArray()){

            if(underscoreList.contains(iterator)){
                int index = underscoreList.lastIndexOf(iterator);
                if(index % 2 == 0){
                    resultArr[insertPosition] = "_".charAt(0);
                    insertPosition++;

                    resultArr[insertPosition] = str.charAt(iterator);
                    iterator++;
                    insertPosition++;
                }else{
                    resultArr[insertPosition] = str.charAt(iterator);
                    iterator++;
                    insertPosition++;

                    resultArr[insertPosition] = "_".charAt(0);
                    insertPosition++;
                }
            }else{
                resultArr[insertPosition] = str.charAt(iterator);
                iterator++;
                insertPosition++;
            }

        }
        return new String(resultArr);
    }

    private static Integer[] checkIfNextSubstringMatches(int i, String str, String substring) {
        Integer[] result = new Integer[2];
        result[0] = i;
        int j = 0;
        while(i < str.length()){
            if(str.charAt(i) == substring.charAt(j)){
                if(j == substring.length()-1){
                    result[1] = i;
                }
                i++;
                j++;
                j = j % substring.length();
            }else {
                break;
            }
        }
        return result;
    }


}
