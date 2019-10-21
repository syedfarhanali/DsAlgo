package algoexpert.dynamicProgramming;

import util.Utils;

public class WaterArea {

    public static void main(String[] args) {
        int[] denoms = new int[]{0,8,0,0,5,0,0,10,0,0,1,1,0,3};
        Utils.print(waterArea(denoms));
    }

    public static int waterArea(int[] heights) {

        int[] maxLeft = new int[heights.length];
        int[] maxRight = new int[heights.length];
        int water = 0;

        int maxLeftHeight = 0;
        int maxRightHeight = 0;

        for(int i=0; i< heights.length ; i++){
            maxLeft[i] = maxLeftHeight;
            if(heights[i] > maxLeftHeight){
                maxLeftHeight = heights[i];
            }

            maxRight[heights.length-1-i] = maxRightHeight;
            if(heights[heights.length-1-i] > maxRightHeight){
                maxRightHeight = heights[heights.length-1-i];
            }
        }

        for(int i=0 ; i< heights.length ; i++){
            if (heights[i] <  Math.min(maxLeft[i], maxRight[i]) ){
                water = water + Math.min(maxLeft[i], maxRight[i]) - heights[i] ;
            }
        }

        return water;
    };
}
