package algoexpert.recursion;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static void main(String[] args) {

        List<Object> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        array.add(new ArrayList<Object>(Arrays.asList(new Object[]{7, -1}) ));
        array.add(3);

        List<Object> l1 = new ArrayList<>();
        l1.add(-13);
        l1.add(8);

        List<Object> l2 = new ArrayList<>();
        l2.add(6);
        l2.add(l1);
        l2.add(4);
        array.add(l2 );

        Utils.print(productSum(array));
    }

    public static int productSum(List<Object> array) {
        return productSumHelper(array,1);
    }

    public static int productSumHelper(List<Object> array, int depth) {
        int sum = 0;
        for(Object o : array){
            if(o instanceof ArrayList){
                sum = sum + productSumHelper((ArrayList)o,depth+1);
            }else{
                sum = sum + (int)o;
            }
        }
        return sum * depth;
    }
}
