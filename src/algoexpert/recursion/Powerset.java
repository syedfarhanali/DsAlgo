package algoexpert.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Powerset {

    public static void main(String[] args) {

        List<Integer> array = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3}));


        System.out.println(powersetNormal(array));
        System.out.println(powersetRecursion(array));
    }

    public static List<List<Integer>> powersetRecursion(List<Integer> array) {

        if(array.size() == 0){
            List<List<Integer>> result =  new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }else{
            Integer element = array.get(0);
            array.remove(0);
            List<List<Integer>> result = powersetRecursion(array);
            int size = result.size();
            for(int i=0 ;i < size ;i++){
                List<Integer> temp = new ArrayList<>(result.get(i));
                temp.add(element);
                result.add(temp);
            };
            return result;
        }
    }



    public static List<List<Integer>> powersetNormal(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i=0 ; i <array.size() ;i++){
            int length = result.size();
            for(int j = 0 ;j <length ;j++){
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(array.get(i));
                result.add(newList);
            }
        }
        return result;
    }
}
