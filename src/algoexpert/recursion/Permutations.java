package algoexpert.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3}));
        getPermutations(list);
        System.out.println(getPermutations(list).size());
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getPermutationsHelper(array,new ArrayList<>(),result);
        return  result;
    }

    public static void getPermutationsHelper(List<Integer> array,List<Integer> perm,List<List<Integer>> result){

        if(array.size() == 0 && perm.size()>0){
            result.add(perm);
        }else{
            for(Integer i : array){
                List<Integer> newList = new ArrayList<>(array);
                newList.remove(i);
                List<Integer> newPerm = new ArrayList<>(perm);
                newPerm.add(i);
                getPermutationsHelper(newList,newPerm,result);
            }
        }
    }
}
