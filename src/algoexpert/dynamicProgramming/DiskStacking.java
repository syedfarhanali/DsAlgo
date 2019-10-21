package algoexpert.dynamicProgramming;

import util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DiskStacking {

    public static void main(String[] args) {

        ArrayList<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{2,1,2});
        list.add(new Integer[]{3,2,3});
        list.add(new Integer[]{2,2,8});
        //list.add(new Integer[]{2,3,4});
        //list.add(new Integer[]{1,3,1});
        //list.add(new Integer[]{4,4,5});

        ArrayList<Integer[]> result =  diskStacking(list);

    }

    public static ArrayList<Integer[]> diskStacking(ArrayList<Integer[]> disks) {

        ArrayList<Integer[]> result = new ArrayList<>();

        Collections.sort(disks, (d1, d2) -> { return d1[2].compareTo(d2[2]);});

        //Collections.sort(disks, Comparator.comparing(d -> d[2]));

        int[] height = new int[disks.size()];
        Integer maxIndex = 0;
        Integer maxHeight = 0;
        Integer[] prevIndex = new Integer[disks.size()];

        for(int i=0; i < disks.size() ; i++){

            Integer[] d = disks.get(i);
            height[i] = d[2];

            for(int j = 0 ; j< i ; j++){
                Integer[] o = disks.get(j);

                if(o[0] < d[0] && o[1] < d[1] && o[2] < d[2]){
                    if(d[2] + height[j] > height[i]){
                        height[i] = d[2] + height[j];
                        prevIndex[i] = j;

                    }
                }
            }
            if(height[i]>maxHeight){
                maxHeight = height[i];
                maxIndex = i;
            }

        }

        result.add(disks.get(maxIndex));
        Integer index = prevIndex[maxIndex];

        while(index != null){
            result.add(disks.get(index));
            index = prevIndex[index];

        }

        Collections.reverse(result);
        return result;

    }
}
