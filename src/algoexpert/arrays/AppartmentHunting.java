package algoexpert.arrays;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class AppartmentHunting {

    public static void main(String[] args) {

        Map<String, Boolean> block0 = new HashMap<>();
        block0.put("gym",Boolean.TRUE);
        block0.put("pool",Boolean.FALSE);
        block0.put("school",Boolean.TRUE);
        block0.put("store",Boolean.FALSE);

        Map<String, Boolean> block1 = new HashMap<>();
        block1.put("gym",Boolean.FALSE);
        block1.put("pool",Boolean.FALSE);
        block1.put("school",Boolean.FALSE);
        block1.put("store",Boolean.FALSE);

        Map<String, Boolean> block2 = new HashMap<>();
        block2.put("gym",Boolean.FALSE);
        block2.put("pool",Boolean.FALSE);
        block2.put("school",Boolean.TRUE);
        block2.put("store",Boolean.FALSE);

        Map<String, Boolean> block3 = new HashMap<>();
        block3.put("gym",Boolean.FALSE);
        block3.put("pool",Boolean.FALSE);
        block3.put("school",Boolean.FALSE);
        block3.put("store",Boolean.FALSE);

        Map<String, Boolean> block4 = new HashMap<>();
        block4.put("gym",Boolean.FALSE);
        block4.put("pool",Boolean.FALSE);
        block4.put("school",Boolean.FALSE);
        block4.put("store",Boolean.TRUE);

        Map<String, Boolean> block5 = new HashMap<>();
        block5.put("gym",Boolean.TRUE);
        block5.put("pool",Boolean.FALSE);
        block5.put("school",Boolean.FALSE);
        block5.put("store",Boolean.FALSE);

        Map<String, Boolean> block6 = new HashMap<>();
        block6.put("gym",Boolean.FALSE);
        block6.put("pool",Boolean.FALSE);
        block6.put("school",Boolean.FALSE);
        block6.put("store",Boolean.FALSE);

        Map<String, Boolean> block7 = new HashMap<>();
        block7.put("gym",Boolean.FALSE);
        block7.put("pool",Boolean.FALSE);
        block7.put("school",Boolean.FALSE);
        block7.put("store",Boolean.FALSE);

        Map<String, Boolean> block8 = new HashMap<>();
        block8.put("gym",Boolean.FALSE);
        block8.put("pool",Boolean.FALSE);
        block8.put("school",Boolean.FALSE);
        block8.put("store",Boolean.FALSE);

        Map<String, Boolean> block9 = new HashMap<>();
        block9.put("gym",Boolean.FALSE);
        block9.put("pool",Boolean.FALSE);
        block9.put("school",Boolean.TRUE);
        block9.put("store",Boolean.FALSE);

        Map<String, Boolean> block10 = new HashMap<>();
        block10.put("gym",Boolean.FALSE);
        block10.put("pool",Boolean.TRUE);
        block10.put("school",Boolean.FALSE);
        block10.put("store",Boolean.FALSE);

        List<Map<String, Boolean>> blocks = new ArrayList<>();
        blocks.add(block0);
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(block4);
        blocks.add(block5);
        blocks.add(block6);
        blocks.add(block7);
        blocks.add(block8);
        blocks.add(block9);
        blocks.add(block10);

        String[] reqs = new String[]{"gym","pool","school","store"};

       System.out.println(apartmentHunting(blocks,reqs))    ;


    }

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {

        Set<String> keys = blocks.get(0).keySet();
        List<Integer[]> blockDistances = new ArrayList<>();

        for (String key: reqs) {
            Integer[] distance= getBuildingDistanceInEachBlock(blocks,key);
            blockDistances.add(distance);
        }

        Integer[] maxDistanceTracker = new Integer[blocks.size()];
        Integer overAllMinDistance = Integer.MAX_VALUE;
        Integer overAllMinDistanceIndex = null;
        for(int i=0; i< blocks.size() ;i++){
            maxDistanceTracker[i] = getMaxDistanceAtIndex(blockDistances,i);

            if(maxDistanceTracker[i] < overAllMinDistance){
                overAllMinDistance = maxDistanceTracker[i];
                overAllMinDistanceIndex = i;
            }
        }

        return overAllMinDistanceIndex;
    }

    private static Integer getMaxDistanceAtIndex(List<Integer[]> blockDistances, int i) {

        Integer maxBuildingDistance = Integer.MIN_VALUE;

        for(Integer[] buildingDistances : blockDistances){
            if(buildingDistances[i] > maxBuildingDistance){
                maxBuildingDistance = buildingDistances[i];
            }
        }
        return maxBuildingDistance;
    }

    private static Integer[] getBuildingDistanceInEachBlock(List<Map<String, Boolean>> blocks, String key) {

        Integer[] result = new Integer[blocks.size()];
        Map<String,Boolean> prevBlock = null;

        for(int i=0; i< blocks.size() ;i++){
            Map<String,Boolean> block = blocks.get(i);
            if(block.get(key).equals(Boolean.TRUE)){
                result[i] = 0;
            }else if(i!=0 && result[i-1]!=null){
                result[i] = result[i-1] + 1;
            }
        }


        for(int i=blocks.size()-1; i>=0 ;i--){
            Map<String,Boolean> block = blocks.get(i);
            if(i!=blocks.size()-1 && result[i+1]!=null){
                if(result[i] == null || (result[i+1] + 1 < result[i])){
                    result[i] = result[i+1] + 1;
                }

            }
        }

        return result;
    }


}
