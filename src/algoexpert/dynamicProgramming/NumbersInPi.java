package algoexpert.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class NumbersInPi {

    public static void main(String[] args) {

        String pi = "3141592653589793238462643383279";
        String[] numbers = {"314159265358979323846","26433","8","3279","314159265","35897932384626433832","79"};

        System.out.println(numbersInPi(pi,numbers));
    }

    public static int numbersInPi(String pi, String[] numbers) {

        HashMap<String,Boolean> numberMap = new HashMap<>();
        HashMap<Integer,Integer> cache = new HashMap<>();
        Arrays.stream(numbers).forEach(n -> numberMap.put(n,Boolean.TRUE));
        return numbersInPi ( pi,numberMap,0,cache);
    }

    public static int numbersInPi(String pi, HashMap<String,Boolean> numberMap, int index,HashMap<Integer,Integer> cache) {

        if(index==pi.length()){
            return -1;
        }else if(cache.containsKey(index)){
            return cache.get(index);
        }

        int minSpaces = Integer.MAX_VALUE;

        for(int i=index ;i < pi.length() ; i++){
            String number = pi.substring(index,i+1);
            if(numberMap.containsKey(number)){
                int minSpaceinSuffix = numbersInPi ( pi,numberMap,i+1,cache);
                minSpaces = Math.min(minSpaces,minSpaceinSuffix + 1);

               /* if(minSpaces == Integer.MAX_VALUE){
                    minSpaces = Math.min(minSpaces,minSpaceinSuffix);
                }else{
                    minSpaces = Math.min(minSpaces,minSpaceinSuffix + 1);
                }*/
            }
        }
        cache.put(index,minSpaces);
        return minSpaces;
    }
}
