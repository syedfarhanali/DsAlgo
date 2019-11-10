package algoexpert.strings;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class PatternMatcher {

    public static void main(String[] args) {

        String s = "abab";
        String p = "yxyx";
        Utils.print(patternMatcher(p,s));

    }

    public static String[] patternMatcher(String pattern, String str) {

        String newPattern = getPatternStartingWithX(pattern);

        Boolean hasSwitched = ! (newPattern.equals(pattern));

        List<Integer> countsAndYStart = getCountsAndFirstStartOfY(newPattern);

        Integer xCount = countsAndYStart.get(0);
        Integer xLength = 1;

        while(xLength * xCount <= str.length()){
            List<String> potentialResult = getPotentialResult(xLength, countsAndYStart,str);
            if(isPotentialResultTheSolution(potentialResult,str,newPattern)){
                if(hasSwitched){
                    return new String[]{potentialResult.get(1),potentialResult.get(0)};
                }
                return new String[]{potentialResult.get(0),potentialResult.get(1 )};
            }else {
                xLength++;
            }
        }

        return new String[]{};

    }


    public static boolean isPotentialResultTheSolution(List<String> potentialResult, String str, String pattern){

        StringBuilder newString = new StringBuilder();
        for(int i=0 ; i< pattern.length() ;i++){
            if(pattern.charAt(i) == 'x'){
                newString.append(potentialResult.get(0));
            }else{
                newString.append(potentialResult.get(1));
            }
        }
        if(str.equals(newString.toString())){
            return true;
        }
        return false;
    }



    public static List<String> getPotentialResult(Integer xLength, List<Integer> countsAndYStart, String str){

        List<String> result = new ArrayList<>();
        Integer xCount = countsAndYStart.get(0);
        Integer yCount = countsAndYStart.get(1);
        Integer yStartInPattern = countsAndYStart.get(2);

        Integer yLength = 0;
        Integer yStartInString=0;
        String y = "";
        if(yCount != 0){
            yLength   =  (str.length() - (xLength * xCount)) / yCount ;
            yStartInString = yStartInPattern * xLength;
            y = str.substring(yStartInString,yStartInString+yLength);

        }


       if(yLength % 1 != 0 ){
           return null;
       }

       String x = str.substring(0,xLength);

       result.add(x);
       result.add(y);

       return result;
    }


    public static List<Integer> getCountsAndFirstStartOfY(String pattern){

        List<Integer> count = new ArrayList<>();
        // return count of x and y.
        Integer xCount=0;
        Integer yCount=0;
        Integer yStart=null;
        for(int i=0 ; i< pattern.length(); i++ ){
            char c = pattern.charAt(i);
            if(c == 'x'){
                xCount++;
            }else {
                yCount++;
                if(yStart == null){
                    yStart = i;
                }
            }
        }

        count.add(xCount);
        count.add(yCount);
        count.add(yStart);
        return count;
    }




    public static String getPatternStartingWithX(String pattern){

        if(pattern.startsWith("x")){
            return pattern;
        }else{
            String newPattern = "";
            for(int i=0 ;i < pattern.length() ;i++){
                if(pattern.charAt(i) == 'x'){
                    newPattern = newPattern + "y";
                }else{
                    newPattern = newPattern + "x";
                }
            }
            return newPattern;
        }
    }


}
