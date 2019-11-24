package algoexpert.famous_algos;

public class KadanesAlgorithm {

    public static void main(String[] args) {

        int[] arr = new int[]{-1,-2,-3};
        System.out.println(kadanesAlgorithm(arr));
    }

    public static int kadanesAlgorithm(int[] array) {


        int[] sums = new int[array.length];
        sums[0] = array[0];
        Integer maxSum =array[0];
        for(int i=1 ;i <array.length ;i++){
            sums[i] = Math.max(sums[i-1] + array[i] , array[i]);
            if(sums[i] > maxSum){
                maxSum = sums[i];
            }
        }
        return maxSum;
    }
}
