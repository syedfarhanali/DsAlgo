package algoexpert.arrays;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class ZigZagTraverse {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> array = new ArrayList<>();

        ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,3,4,10}));
        ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{2,5,9,11}));
        ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(new Integer[]{6,8,12,15}));
        ArrayList<Integer> row4 = new ArrayList<Integer>(Arrays.asList(new Integer[]{7,13,14,16}));

        array.add(row1);
        array.add(row2);
        array.add(row3);
        array.add(row4);

        Utils.print(zigzagTraverse(array));

    }

    public static ArrayList<Integer> zigzagTraverse(ArrayList<ArrayList<Integer>> array) {

        Boolean goingDown = Boolean.TRUE;
        Integer height = array.size()-1;
        Integer width = array.get(0).size()-1;
        Integer row = 0;
        Integer col = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while ( row >= 0 && col >=0 && row <= height && col <= width){
            result.add(array.get(row).get(col));
            if(goingDown){
                if(col == 0 || row == height){
                    goingDown = Boolean.FALSE;
                    if(row == height){    // Don't change this to col==0 and an else, it wont work for some cases
                        col++;
                    }else{
                        row++;
                    }
                }else {
                    col--;
                    row++;
                }

            }else {

                if(row == 0 || col == width){
                    goingDown = Boolean.TRUE;

                    if(col == width){  // Don't change this to row==0 and an else, it wont work for some cases
                        row++;
                    }else{
                        col++;
                    }
                }else {
                    row--;
                    col++;
                }
            }
        }
        return result;
    }
}
