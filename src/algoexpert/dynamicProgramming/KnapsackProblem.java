package algoexpert.dynamicProgramming;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapsackProblem {

    public static void main(String[] args) {

        int[][] arr = {{465,100},{400,85},{255,55},{350,45},{650,130},{1000,190},{455,100},{100,25},{1200,190},{320,65},{750,100},{50,45},{550,65},{100,50},{600,70},{240,40}};
        //int arr
        int weight = 200;

        System.out.println(knapsackProblem(arr,weight));

    }


    public static ArrayList<ArrayList<Integer>> knapsackProblem(int[][] items, int capacity) {

        int[][] values = new int[items.length+1][capacity+1];

        for(int i = 1 ; i< items.length+1 ; i++){

            for(int j = 1; j < capacity+1 ; j++){

                int weight = items[i-1][1];
                int value = items[i-1][0];
                if(weight <= j ){
                        values[i][j] = Math.max(values[i-1][j], values[i-1][j- weight]+ value );
                }else{
                    values[i][j] = values[i-1][j];
                }
            }
        }

        Utils.print(values);

        int targetValue = values[items.length][capacity];

        Utils.print(targetValue);

        return extractItems(values,targetValue,items,capacity);
    }

    public static ArrayList<ArrayList<Integer>> extractItems(int[][] values, int targetValue,int[][] items, int capacity){

            int row = items.length;
            int col = capacity;

            ArrayList<Integer> index = new ArrayList<>();
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            while(col !=0 && row !=0){
                if(values[row][col] == values[row-1][col]){
                    row--;
                }else{
                    index.add(row-1);
                    col = col - items[row-1][1];
                    row--;
                }
            }
        Collections.reverse(index);
        result.add(new ArrayList<Integer>(Arrays.asList(targetValue)));
        result.add(index);

        return result;

    }
}
