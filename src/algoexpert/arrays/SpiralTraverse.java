package algoexpert.arrays;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {

            List result = new ArrayList<Integer>();
            String direction = "right";
            int x=0;
            int y=0;
            int xUpperLimit= array.length-1;
            int xLowerLimit=1;
            int yUpperLimit=array[0].length-1;
            int yLowerLimit=0;

            int i=0;

            while(i< (array.length * array[0].length) ) {
                i++;
                result.add(array[x][y]);
                if(direction.equals("right")){
                    if(y==yUpperLimit){
                        direction="down";
                        yUpperLimit--;
                        x++;
                    }else{
                        y++;
                    }
                }else if(direction.equals("down")){
                    if(x==xUpperLimit){
                        direction="left";
                        xUpperLimit--;
                        y--;
                    }else{
                        x++;
                    }
                }else if(direction.equals("left")){
                    if(y==yLowerLimit){
                        direction="up";
                        yLowerLimit++;
                        x--;
                    }else{
                        y--;;
                    }
                }else if(direction.equals("up")){
                    if(x==xLowerLimit){
                        direction="right";
                        xLowerLimit++;
                        y++;
                    }else{
                        x--;;
                    }
                }



            }


            return result;
        }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        Utils.print(spiralTraverse(arr));
    }
}
