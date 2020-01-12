package algoexpert.arrays;

import util.Utils;

import javax.rmi.CORBA.Util;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(new Integer[]{2,1,2,2,2,3,4,2});

        Utils.print(moveElementToEnd(list,2));

    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int left = 0;
        int right = array.size()-1;


        while(left < right){

            if(array.get(left).equals(toMove) && !array.get(right).equals(toMove)){
                Integer temp = array.get(left);
                array.set(left,array.get(right));
                array.set(right,temp);
            }

            if(!array.get(left).equals(toMove)){
                left++;
            }
            if(array.get(right).equals(toMove)){
                right--;
            }

        }

        return array;

    }
}
