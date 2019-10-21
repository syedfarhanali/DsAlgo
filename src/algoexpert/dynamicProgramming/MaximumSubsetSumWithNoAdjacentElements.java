package algoexpert.dynamicProgramming;

public class MaximumSubsetSumWithNoAdjacentElements {

    public static void main(String[] args) {

        int[] arr = new int[]{75,105,120,75,90,135};

        System.out.println(maxSubsetSumNoAdjacentOne(arr));
    }

    public static int maxSubsetSumNoAdjacentOne(int[] a) {

        if(a.length == 0)
            return 0;
        else if(a.length == 1)
            return a[0];
        else{

            int nonAdjMax = a[0];
            int adj = a[1];

            for(int i=2; i< a.length; i++){

                int current = a[i] + nonAdjMax;

                nonAdjMax = Math.max(nonAdjMax,adj);

                adj = current;
            }

            int maxsum = nonAdjMax > adj ? nonAdjMax : adj;

            return  maxsum;
        }


    }

}
