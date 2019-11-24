package algoexpert.graphs;

import util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RiverSizes {

    public static void main(String[] args) {

        int[][] arr  = new int[][]{{1,0,0,1,0},{1,0,1,0,0},{0,0,1,0,1},{1,0,1,0,1},{1,0,1,1,0}};
        Utils.print(riverSizes(arr));
    }

    public static List<Integer> riverSizes(int[][] matrix) {

        List<Integer> rivers = new ArrayList<Integer>();
        Map<String,Boolean> visited = new HashMap<String, Boolean>();

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(Boolean.TRUE.equals(visited.get(row + "-" + col))){
                    continue;
                }else if(matrix[row][col] == 0){
                    visited.put(row + "-" + col, true);
                }else {
                    rivers.add(visitRiver(matrix,row,col,visited,0));
                }
            }
        }

        return rivers;
    }


    private static int visitRiver(int[][] matrix, int row, int col, Map<String, Boolean> visited,Integer riverLength) {
        visited.put(row + "-" + col, true);
        if(row >= 0 && row<matrix.length && col>= 0 && col< matrix[0].length && matrix[row][col]== 1){
                riverLength++;
                if(!Boolean.TRUE.equals(visited.get(row+"-"+(col-1)))){
                    riverLength= visitRiver(matrix,row,col-1,visited,riverLength);
                }
                if(!Boolean.TRUE.equals(visited.get((row-1)+"-"+(col)))){
                    riverLength = visitRiver(matrix,row-1,col,visited,riverLength);
                }
                if(!Boolean.TRUE.equals(visited.get(row+"-"+(col+1)))){
                    riverLength = visitRiver(matrix,row,col+1,visited,riverLength);
                }
                if(!Boolean.TRUE.equals(visited.get((row+1)+"-"+(col)))){
                    riverLength =  visitRiver(matrix,row+1,col,visited,riverLength);
                }
        }

        return riverLength;
    }
}
