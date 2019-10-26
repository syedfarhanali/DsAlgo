package algoexpert.arrays;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumRewards {

    public static void main(String[] args) {

        int[] arr = new int[]{0,4,2,1,3};
        Utils.print(minRewards1(arr));

    }



    // Solution 1 : Calculate local minimums and increase towards left and right till local maximum is reached do this fir all local minimums
    public static int minRewards1(int[] scores) {

        List<Integer> localMins = new ArrayList<>();

        if(scores.length <2){
           return 1;
        }else if(scores.length == 2){
            return 3;
        }

        for(int i = 0 ;i< scores.length; i++){
            if(i == 0 && scores[i] < scores[i+1]){
                localMins.add(i);
            }else if(i == scores.length-1 && scores[i] < scores[i-1]){
                localMins.add(i);
            }else if(i != 0 && scores[i-1]>scores[i] &&  scores[i] < scores[i+1]){
                localMins.add(i);
            }
        }

        int[] rewards = new int[scores.length];

        localMins.forEach((i)->{
            int currentIndex = i;
            rewards[currentIndex] = 1;
            int left = currentIndex-1;
            int right = currentIndex+1;

            while (left != -1 && scores[left] > scores[left+1]){
                rewards[left] = Math.max(rewards[left],rewards[left+1]+1);
                left--;
            }

            while(right!= scores.length && scores[right] > scores[right-1]){
                rewards[right] = Math.max(rewards[right],rewards[right-1] + 1);
                right++;
            }


        });

        return Arrays.stream(rewards).sum();

    }


    // Solution 3 loop through the array if next element is greater increase the reward if its smaller decrease the reward,
    // if while decreasing reward becomes zero then increase all previous rewards to be either current element +1 OR their current value
    // which ever is greater


    public static int minRewards3(int[] scores) {


        if(scores.length <2){
            return 1;
        }else if(scores.length == 2){
            return 3;
        }
        int[] rewards = new int[scores.length];

        rewards[0] = 1;

        for(int i = 1 ; i< scores.length ;i++){
            if(scores[i] > scores[i-1]){
                rewards[i] = rewards[i-1] + 1;
            }else{
                rewards[i] = 1;
                if(rewards[i-1] == 1){
                    int j = i-1;
                    while (j>=0){
                        if(scores[j] < scores[j+1]){
                            break;
                        }
                        rewards[j] = Math.max(rewards[j], rewards[j+1] + 1);
                        j--;
                    }
                }
            }
        }
        return Arrays.stream(rewards).sum();
    }


    
}
