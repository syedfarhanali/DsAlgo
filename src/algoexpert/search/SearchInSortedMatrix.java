package algoexpert.search;

import util.Utils;

public class SearchInSortedMatrix {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1,4,7,12,15,1000},
                {2,5,19,31,32,1001},
                {3,8,24,33,35,1002},
                {40,41,42,43,45,1003},
                {99,100,103,106,113,1004}
        };

        Utils.print(searchInSortedMatrix(arr, 1004));
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {

        int height = matrix.length;
        int width = matrix[0].length;


        int i = 0;
        int j = width-1;

        while (i < height && j>=0){

            int current = matrix[i][j];

            if( current== target){
                return new int[]{i,j};
            }else if(current > target){
                j = j-1;
            }else{
                i = i+1;
            }

        }
        return new int[]{-1,-1};
    }
}
