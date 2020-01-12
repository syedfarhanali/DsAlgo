package algoexpert.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBST {

    public static void main(String[] args) {

        List<Integer> a1 = Arrays.asList(new Integer[]{10,15,8,12,94,81,5,2,11});
        List<Integer> a2 = Arrays.asList(new Integer[]{10,8,5,15,2,12,11,94,81});

        System.out.println(sameBsts(a1,a2));

    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

        if(arrayOne.size() == 0 && arrayTwo.size() == 0) return true;
        if(arrayOne.size()!= arrayTwo.size()) return false;
        if(!arrayOne.get(0).equals(arrayTwo.get(0))) return false;


        List<List<Integer>> first = getLeftAndRightSubtree(arrayOne);
        List<List<Integer>> second = getLeftAndRightSubtree(arrayTwo);

        return sameBsts(first.get(0),second.get(0)) && sameBsts(first.get(1),second.get(1));


    }

    private static List<List<Integer>> getLeftAndRightSubtree(List<Integer> array) {

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i=1; i< array.size() ;i++){
            if(array.get(i) < array.get(0)){
                left.add(array.get(i));
            }else{
                right.add(array.get(i));
            }
        }

        result.add(left);
        result.add(right);
        return result;
    }


}
